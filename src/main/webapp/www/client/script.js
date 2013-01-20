var NovyMail = {

    pricingModel: {
        starterPackage: {
            monthly: 59,
            quarterly: 59*3,
            yearly: 59*12
        },
        standardPackage: {
            monthly: 1599,
            quarterly: 1599*3,
            yearly: 1599*11
        },
        professionalPackage: {
            monthly: 2299,
            quarterly: 2299*3,
            yearly: 2299*11
        }
    },

    lookupCompanyUrl: location.host+':8080/rest/register/lookupCompany/',
    checkDomainUrl: location.host+':8080/rest/register/check/domain/',
    checkUsernameUrl: location.host+':8080/rest/register/check/username/',

    aresLookUp: function(ico) {
        if (typeof ico == 'undefined' || ico == '') {
            return;
        }

        var url = lookupCompanyUrl;
        url += ico;
        $.getJSON(url, function(d) {
            if (d.ok) {
                alert('Company: '+d.data.company);
            } else {
                alert('Chyba: '+d.code);
            }
        });
    },

    checkDomain: function(domain) {

    },

    checkUsername: function(username) {

    }

}

function isInt(n) {
  return !isNaN(parseInt(n)) && isFinite(n);
}

$(function() {

    /* =============================== GENERAL SETUP ======================== */
//    $.fn.editable.defaults.mode = 'inline';

    /* =============================== PAGE TOP NAV BAR ===================== */
    $('.nav').localScroll({hash: true});
    $('#signUpMain').click(function () {
        $.scrollTo('#sign-up', 2000);
    });
    
    $('[rel="tooltip"]').tooltip();

    $('[href="#try-out"]').click(function(){
        location.href = '/preauth.php';
    });

    $('[href="#try-out-simple"]').click(function(){
        location.href = '/preauth.php?t=h';
    });

    $('[href="#try-out-mobile"]').click(function(){
        location.href = '/preauth.php?t=m';
    });

/* ================= PACKAGES BUTTONS BASIC - STANDARD - PROFESSIONAL ======= */

    $('[href="#sign-up-starter"]').click(function() {
        if ($('#registerCarousel').css('display') != 'none') {
            $(this).removeClass('btn-link');
            $('#registerCarousel').hide(function() {
                $('#packageStandard').add('#packageProfessional').
                    add('#packageStarter').show();                
            });
        } else {
            $(this).addClass('btn-link');
            $('#packageStandard').add('#packageProfessional').hide(function() {
                $('#registerCarousel').show();
            });
        }
    });

    $('[href="#sign-up-standard"]').click(function() {
        if ($('#registerCarousel').css('display') != 'none') {
            $(this).removeClass('btn-link');            
            $('#registerCarousel').hide(function() {
                $('#packageStandard').add('#packageProfessional').
                    add('#packageStarter').show();
            });
        } else {
            $(this).addClass('btn-link');            
            $('#packageStarter').add('#packageProfessional').hide(function() {
                $('#registerCarousel').show();            
            });
        }
    });

    $('[href="#sign-up-professional"]').click(function() {
        if ($('#registerCarousel').css('display') != 'none') {
            $(this).removeClass('btn-link');            
            $('#registerCarousel').hide(function() {
                $('#packageStandard').add('#packageProfessional').
                    add('#packageStarter').show();
            });
        } else {
            $(this).addClass('btn-link');            
            $('#packageStandard').add('#packageStarter').hide(function() {
                $('#registerCarousel').show();            
            });
        }
    }); 

/* ============= REGISTER FORM STEP ONE =================================== */

    $('#domainInput').blur(function() {

    });

    $('#domainRegisterButton').click(function() {

    });

    $('#domainTransferButton').click(function() {

    });


/* ============= REGISTER FORM STEP TWO =================================== */



    $('.register-editable').editable({

    });

    $('#emails').editable({
        select2: {
            tags: ['jmeno@prijmeni.cz', 'ivan.novak@seznam.cz'],
            tokenSeparators: [',', ' ']
        }
    });

    $('#package').editable({        
        value: 'starter',
        source: [
            {value: 'starter', text: 'Starter 1 - 15 (placený za schránku)'},
            {value: 'standard', text: 'Standard 15 - 30 (placený paušálně)'},
            {value: 'professional', text: 'Professional 30 - 50 (placený paušálně)'}
        ]
    });

    $('#period').editable({        
        value: 'monthly',
        source: [
            {value: 'monthly', text: 'Měsíčně'},
            {value: 'quarterly', text: 'ˇCtvrtletně'},
            {value: 'yearly', text: 'Ročně (1 měsíc zdarma)'}
        ]
    });    

    // move automatically to the next form field
    // $('.register-editable').on('hidden', function(e, reason){
    //     if(reason === 'save' || reason === 'nochange') {
    //         var $next = $(this).closest('tr').next().find('.editable');            
    //         setTimeout(function() {
    //             $next.editable('show');
    //         }, 300);             
    //     }
    // });

    // $('#address').editable({
    //     value: {
    //         street: "Lenina", 
    //         number: "15",
    //         zip: "124356",
    //         district: "Browning",
    //         city: "Moscow", 
    //         region: "Highlands",
    //         country: "England"            
    //     }
    // });
    
    $('#customerInput')
        .focus(function() {
            $('#registerCompanyButton').removeClass('btn-primary');
            $('#registerPersonButton').removeClass('btn-primary');
        })
        .blur(function() {
            if ($(this).val() != "") {
                if (isInt($(this).val())) {
                    // register firm
                    $('#registerCompanyButton').addClass('btn-primary');
                } else {
                    // register personal
                    $('#registerPersonButton').addClass('btn-primary');
                }                 
            }
        }
    );    

    $('#registerCompanyButton').click(function() {

    });

    $('#registerPersonButton').click(function() {

    });



});