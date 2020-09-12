var main = {
    init           : function () {
        var _this = this;

        $('button[name=open-reply-modify]').on('click', function (e) {
            _this.openReplyModify(e.target);
        });
        $('button[name=open-rereply-save]').on('click', function (e) {
            _this.openRereplySave(e.target);
        });


        $('#btn-reply-save').on('click', function () {
            _this.replySave();
        });
        $('button[name=btn-reply-modify]').on('click', function (e) {
            _this.replyModify(e.target);
        });


        $('button[name=btn-rereply-save]').on('click', function (e) {
            _this.rereplySave(e.target);
        });


        $('.div-rereply-save').hide();
    },
    replySave           : function () {
        var data = {
            postNo: $('#postNo').val(),
            boardName: $('#boardName').val(),
            content: $('#reply-content').val()
        };

        console.log(data);

        $.ajax({
            type: 'POST',
            url: '/board/study/posts/reply/save',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            window.location.href='/board/study/posts/read?postNo='+data.postNo;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    replyModify : function (target) {
        var div = $(target).closest('div[name=div-one-reply]')[0];

        var data = {
            replyNo: $(div).children('input[name=replyNo]')[0].value,
            content: $(target).prev().val()
        };

        $.ajax({
            type: 'POST',
            url: '/board/study/posts/reply/update',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            window.location.href='/board/study/posts/read?postNo='+data.postNo;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    rereplySave : function (target) {
        var div = $(target).closest('div[name=wrapped-each-reply]');

        var data = {
            replyNo : $(div).find('input[name=replyNo]')[0].value,
            content : $(div).find('textarea[name=rereply-content]')[0].value,
            postNo : $('#postNo').val(),
            boardName : $('#boardName').val()
        };

        $.ajax({
            type: 'POST',
            url: '/board/study/posts/rereply/save',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            window.location.href='/board/study/posts/read?postNo='+data.postNo;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    openReplyModify: function (target) {
        var wrappedDiv = $(target).closest('div');

        var p = $(wrappedDiv).children('p[name=p-reply-modify]')[0];
        var div = $(wrappedDiv).children('div[name=div-reply-modify]')[0];

        if($(div).css('display') === 'none') {
            $(div).css('display', 'flex');
            $(p).css('display', 'none');
        } else {
            $(p).css('display', 'flex');
            $(div).css('display', 'none');
        }
    },
    openRereplySave: function (target) {
        var div = $(target).closest('div').nextAll('.div-rereply-save')[0];

        if($(div).css("display") === "none") {
            $(div).show()
        } else {
            $(div).hide();
        }
    }
};

main.init();