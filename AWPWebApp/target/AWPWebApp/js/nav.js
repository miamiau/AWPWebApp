$('#nav1').click(function() {
    serverdata = "Pretend I'm data fetched from server #1."
    $('#updatepage').text(serverdata);
    return false;
});

$('#nav2').click(function() {
    serverdata = "Pretend I'm data fetched from another server far, far away."
    $('#updatepage').text(serverdata);
    return false;
});