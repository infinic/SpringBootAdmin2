$(document).ready(function() {
    $('body').on('click', '.user-edit-button', function () {
        let row = $(this).closest('tr');
        let id = row.find('td').eq(0).html();
        let name = row.find('td').eq(1).html();
        let username = row.find('td').eq(2).html();
        var roles = []
        row.find('td').eq(3).find('span').each(function () {roles.push($(this).attr('data-role'))});
        let enabled = (row.find('td').eq(4).html() == 'Yes') ? true : false;

        $('#userEditModal').find('#id').val(id);
        $('#userEditModal').find('#name').val(name);
        $('#userEditModal').find('#username').val(username);
        $('#userEditModal').find('#password').val('');
        $.each(roles, function (i, value) {$('#userEditModal').find('#roles').find('option[value='+value+']').prop('selected', true);});
        $('#userEditModal').find('input[name=enabled]').prop('checked', enabled);
    });

    $('body').on('click', '.user-delete-button', function () {
        let row = $(this).closest('tr');
        let id = row.find('td').eq(0).html();
        let name = row.find('td').eq(1).html();
        let username = row.find('td').eq(2).html();
        var roles = []
        row.find('td').eq(3).find('span').each(function () {roles.push($(this).attr('data-role'))});
        let enabled = (row.find('td').eq(4).html() == 'Yes') ? true : false;

        $('#userDeleteModal').find('#id').val(id);
        $('#userDeleteModal').find('#name').val(name);
        $('#userDeleteModal').find('#username').val(username);
        $.each(roles, function (i, value) {$('#userDeleteModal').find('#roles').find('option[value='+value+']').prop('selected', true);});
        $('#userDeleteModal').find('input[name=enabled]').prop('checked', enabled);
    });
});
