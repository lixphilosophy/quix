$(document).ready(function(){
    $('#view-quiz-table').DataTable({
      "scrollCollapse": true,
      "scrollY": "50vh",
      "lengthChange": false,
      "pageLength": 20
    });

  $('#view-profile-table').DataTable({
    "scrollCollapse": true,
    "scrollY": "50vh",
    "lengthChange": false,
    "pageLength": 20
  });

  $('#view-modified-table').DataTable({
    "scrollCollapse": true,
    "scrollY": "50vh",
    "lengthChange": false,
    "pageLength": 20
  });
});
