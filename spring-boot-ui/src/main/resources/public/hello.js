$(document).ready(function() {
    $.ajax({
        dataType: 'text',
        url: "/hostname"
    }).then(function(data) {
        // console.log("id: " + JSON.parse(data));
        // console.log("id: " + data.data[0].birth);
        console.log("length: " + data);
        console.log("content: " + data);
        $('.greeting-id').append(data);
        $('.greeting-content').append(data);
        //.append($('.greeting - id');
        //for (var i = 0; i < data.data.length; i++) {
        // $('.greeting-id').append(data.data[i].birth);
        // $('.greeting-content').append(data.data[i].name);
        //}
    });
});
$(document).ready(function() {
    $('#queuetable').DataTable({
        serverSide: true,
        ajax: '/client',
        //ajax: 'arrays.txt',
        lengthChange: false,
        data: [],
        language: {
            search: ""
        },
        pageLength: 10,
        /*columns: [{
            name: 'name',
            data: 'name'
        }, {
            name: 'birth',
            data: 'birth'
        }, {
            name: 'eyes',
            data: 'eyes'
        }]*/

        "columns": [
            { "data": "name" },
            { "data": "birth" },
            { "data": "eyes" }
        ]
    });
});