$(document).ready(
    function () {
        function delayRelease() {
            setTimeout(function () {
                // $('.img.btn.img-trim-edges').removeClass('disabled');
                console.log("BTNs Unlocked !!!");
            }, 2000);
        }

        $("#code-name-submit").click(
            function (e) {
                e.preventDefault();
                var codeName = $("#codename-inline").val();
                document.cookie = "codename=" + codeName + "; expires=Wed, 18 Dec 2023 12:00:00 GMT";//expires=Thu, 18 Dec 2013 12:00:00 UTC";
                $('#codeNameModal').modal('hide');
            });

        $(window).bind('load', function () {
            var cookie = document.cookie;

            if (cookie === "") {
                $('#codeNameModal').modal();
            }
        });


        var matchTable = $('#match-table').DataTable({
            "lengthMenu": [[3, 4, 5, 10, 15, 25, 50, 100, -1], [3, 4, 5, 10, 15, 25, 50, 100, "All"]],
            "pageLength": 4,
            "ajax": {
                "url": "/game/match-stats",
                "dataSrc": ""
            },
            "columns": [
                {"data": 'round'},
                {"data": 'me'},
                {"data": 'pc'},
                {"data": 'result'},
                {"data": 'timestamp'}
            ]
        });


        //     <th>id</th>  ------ fixtureNo
        //     <th>codeName</th>
        //     <th>played</th>
        //     <th>won</th>
        //     <th>drew</th>
        //     <th>lost</th>
        //     <th>points</th>
        // private Long id;            // Fixture-No. (Total-Matches Played By All Players)
        // private String codeName;    // Player's name.
        // private Long played;        // Matches-Played
        // private Long won;           // Matches-Won
        // private Long drew;          // Matches-Drawn
        // private Long lost;          // Matches-Lost
        // private Long points;        // Total-Points
        var leagueTable = $('#leader-board-table').DataTable({
            "lengthMenu": [[3, 4, 5, 10, 15, 25, 50, 100, -1], [3, 4, 5, 10, 15, 25, 50, 100, "All"]],
            "pageLength": 4,
            "ajax": {
                "url": "/game/league-table",
                "dataSrc": ""
            },
            "columns": [
                {"data": 'id'},
                {"data": 'codeName'},
                {"data": 'played'},
                {"data": 'won'},
                {"data": 'drew'},
                {"data": 'lost'},
                {"data": 'points'}
            ]
        });


        function castSpell(vChoice) {
            jQuery.ajax({
                type: 'POST',
                url: '/game/cast-spell',
                dataType: 'json',
                contentType: 'application/json',
                async: false,
                data: JSON.stringify({"choice": vChoice}),
                cache: false,
                timeout: 10000,
                success: function (data) {
                    console.log("SUCCESS : ", data);
                    // refreshTable
                    matchTable.ajax.reload();
                    leagueTable.ajax.reload();
                    $('.img.btn.img-trim-edges').removeClass('disabled');
                    console.log("BTNs Unlocked !!!");
                    // $('#registrationModal').modal('hide');
                    // showSuccessPopup("Email Confirmation", data.message);
                    // $("#btnRegisterUser").prop("disabled", false);
                },
                error: function (error) {
                    console.log("ERROR RESP: ", data);
                    $('.img.btn.img-trim-edges').removeClass('disabled');
                    console.log("BTNs Unlocked !!!");
                    if (error.status === 400) {
                        console.log("Error: \n" + error.responseJSON);
                        // isError = true;
                        // popupErrorTitle = titleErrPopupMsg("Validation Error", error.responseJSON.errors.length);
                        // jsonErrMsg = error;
                    } else {
                        console.log("Fatal Error: \n" + error.responseJSON);
                        // showErrPopup("System Failure", "Unexpected response from the system.");
                    }
                }
            });
        }

        $(".btn.mask").click(
            function (e) {
                e.preventDefault();
                var btnID = this.id;

                // $('.img-trim-edges').prop("disabled", true);
                // $('.img.btn.img-trim-edges').attr('disabled', 'disabled');
                if (!$(this).hasClass('disabled')) {
                    $('.img.btn.img-trim-edges').addClass('disabled');
                    console.log("BTN Clicked: ", btnID);
                    console.log("BTNs Locked !!!");
                    // delayRelease();

                    var vChoiceUI;
                    if (btnID === "btn-roc") {
                        vChoiceUI = "ROCK"
                    } else if (btnID === "btn-sci") {
                        vChoiceUI = "SCISSORS"
                    } else {
                        vChoiceUI = "PAPER"
                    }

                    castSpell(vChoiceUI);
                }
            }
        );
    }
);