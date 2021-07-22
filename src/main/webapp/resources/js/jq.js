$(function(){
    $('#apibtn').click(function(){
        $.ajax({
            url:'/team/jq/kakaopay.cls' ,
            dataType:'json' ,
            success: function(data){
                alert();	
                var box = data.next_redirect_pc_url;
                window.open(box);
            } ,
            error: function(error){
                alert(error);
            }
        });
    });
});