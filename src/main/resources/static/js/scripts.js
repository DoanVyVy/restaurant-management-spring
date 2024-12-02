$(document).ready(function() {
    // Thêm hiệu ứng fade-in cho các phần tử khi tải trang
    $(".fade-in").hide().fadeIn(1000);

    // Xác nhận trước khi cập nhật trạng thái đơn hàng
    $("form").submit(function(e) {
        var newStatus = $(this).find("select[name='newStatus']").val();
        var currentStatus = $(this).closest(".order-card").find(".status-badge").text();

        if (newStatus !== currentStatus) {
            if (!confirm("Bạn có chắc chắn muốn cập nhật trạng thái đơn hàng?")) {
                e.preventDefault();
            }
        }
    });

    // Thêm hiệu ứng hover cho các nút
    $("button, select").hover(
        function() {
            $(this).addClass("hover-effect");
        },
        function() {
            $(this).removeClass("hover-effect");
        }
    );
});