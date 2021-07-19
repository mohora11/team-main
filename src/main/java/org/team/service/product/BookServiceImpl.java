package org.team.service.product;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.team.domain.product.CoverVO;
import org.team.domain.product.FileVO;
import org.team.domain.product.ProductVO;
import org.team.mapper.product.BookMapper;
import org.team.mapper.product.ProductFileMapper;

import lombok.Setter;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class BookServiceImpl implements BookService {
	
	private String bucketName;
	private String profileName;
	private S3Client s3;
	
	public BookServiceImpl() {
		this.bucketName = "choongang-eemin90";
		this.profileName = "spring1";
		this.s3 = S3Client.builder()
				.credentialsProvider(ProfileCredentialsProvider.create(profileName))
				.build();
	}

	@Setter(onMethod_ = @Autowired)
	private BookMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private ProductFileMapper fileMapper;
	
	@Override
	public List<ProductVO> getList() {
		return mapper.getList();
	}

	@Override
	public ProductVO get(Long id) {
		return mapper.get(id);
	}
	
	@Override
	public void register(ProductVO product, MultipartFile file1, MultipartFile file2) {
		mapper.insert(product);
		
		if ((file1 != null && file1.getSize() > 0) && (file2 != null && file2.getSize() > 0)) {
			CoverVO vo1 = new CoverVO();
			vo1.setProduct_id(product.getId());
			vo1.setFile_name(file1.getOriginalFilename());
			
			FileVO vo2 = new FileVO();
			vo2.setProduct_id(product.getId());
			vo2.setFile_name(file2.getOriginalFilename());
			
			fileMapper.insertCover(vo1);
			uploadCover(product, file1);
			
			fileMapper.insertFile(vo2);
			uploadFile(product, file2);
		}
	}

	private void uploadCover(ProductVO product, MultipartFile file) {
		try (InputStream is = file.getInputStream()) {
			
			PutObjectRequest objectRequest = PutObjectRequest.builder()
					.bucket(bucketName)
					.key("book/" + product.getId() + "/cover/" + file.getOriginalFilename()) // aws에 "book/product id번호/cover/" 폴더에 파일 저장
					.contentType(file.getContentType())
					.acl(ObjectCannedACL.PUBLIC_READ)
					.build();
			
			s3.putObject(objectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private void uploadFile(ProductVO product, MultipartFile file) {
		try (InputStream is = file.getInputStream()) {
			
			PutObjectRequest objectRequest = PutObjectRequest.builder()
					.bucket(bucketName)
					.key("book/" + product.getId() + "/file/" + file.getOriginalFilename()) // aws에 "book/product id번호/file/" 폴더에 파일 저장
					.contentType(file.getContentType())
					.acl(ObjectCannedACL.PUBLIC_READ)
					.build();
			
			s3.putObject(objectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
