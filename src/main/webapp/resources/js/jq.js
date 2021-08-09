$(function(){
    $('#apibtn').click(function(){
        $.ajax({
            url:'/team/jq/kakaopay.cls' ,
            dataType:'json' ,
            success: function(data){
            	console.log(data);
                alert("결제를 진행합니다");	
                var box = data.next_redirect_pc_url;
                window.open(box);
            } ,
            error: function(error){
                alert(error);
            }
        });
    });
});

