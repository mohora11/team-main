package org.team.service.help;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.team.domain.help.HelpCriteria;
import org.team.domain.help.HelpFileVO;
import org.team.domain.help.HelpVO;
import org.team.mapper.help.HelpFileMapper;
import org.team.mapper.help.HelpMapper;
import org.team.mapper.help.HelpReplyMapper;

import lombok.Setter;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class HelpServiceImpl implements HelpService {
	private String bucketName;
	private String profileName;
	private S3Client s3;
	
	public HelpServiceImpl() {  
		this.bucketName = "choongang-mohora11";
		this.profileName = "spring1";
		this.s3 = S3Client.builder()
				.credentialsProvider(ProfileCredentialsProvider.create(profileName))
				.build();
		
	}

	@Setter (onMethod_ = @Autowired)
	private HelpMapper mapper;
	
	@Setter (onMethod_ = @Autowired)
	private HelpReplyMapper replyMapper;
	
	@Setter (onMethod_ = @Autowired)
	private HelpFileMapper fileMapper;
		
	@Override
	public void register(HelpVO board) {
		mapper.insertSelectKey(board);
	}
	
	@Override
	@Transactional
	public void register(HelpVO board, MultipartFile file) {
		register(board);
		
		if (file != null && file.getSize() > 0) {
			HelpFileVO vo = new HelpFileVO();
			vo.setHno(board.getHno());
			vo.setFileName(file.getOriginalFilename());
			
			fileMapper.insert(vo);
			upload(board, file); 	
		}
	}

	private void upload(HelpVO board, MultipartFile file) {
		
		try (InputStream is = file.getInputStream()) {

			PutObjectRequest objectRequest = PutObjectRequest.builder()
					.bucket(bucketName)
					.key(board.getHno() + "/" + file.getOriginalFilename())
					.contentType(file.getContentType())
					.acl(ObjectCannedACL.PUBLIC_READ)
					.build();
			
			
			s3.putObject(objectRequest, 
					RequestBody.fromInputStream(is, file.getSize()));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public HelpVO get(Long hno) {
		return mapper.read(hno);
	}

	@Override
	public boolean modify(HelpVO board) {
		return mapper.update(board) == 1;
	}
	
	@Override
	@Transactional
	public boolean modify(HelpVO board, MultipartFile file) {
		
		if (file != null & file.getSize() > 0) {
			
			HelpVO oldBoard = mapper.read(board.getHno());
			removeFile(oldBoard);
			upload(board, file);
			
			fileMapper.deleteByHno(board.getHno());
			
			HelpFileVO vo = new HelpFileVO();
			vo.setHno(board.getHno());
			vo.setFileName(file.getOriginalFilename());
			fileMapper.insert(vo);
		
		}
		return modify(board);
	}

	@Override
	@Transactional
	public boolean remove(Long hno) { 
		
		replyMapper.deleteByHno(hno);
		
		HelpVO vo = mapper.read(hno); 
		removeFile(vo);
		
		fileMapper.deleteByHno(hno);
		
		int cnt = mapper.delete(hno);
		
		return cnt == 1;
	} 

	private void removeFile(HelpVO vo) {

		String key = vo.getHno() + "/" + vo.getFileName();
		
		DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
				.bucket(bucketName)
				.key(key)
				.build();
		
		s3.deleteObject(deleteObjectRequest);
		
		
	}

	@Override
	public List<HelpVO> getList(HelpCriteria cri) {
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(HelpCriteria cri) {
		return mapper.getTotalCount(cri);
	}
}
