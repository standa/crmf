

/* ========================================================================== */
/* =============================== GENERAL FUNCTIONS ======================== */
/* ========================================================================== */


function isInt(n) {
  return !isNaN(parseInt(n)) && isFinite(n);
}

String.prototype.killWhiteSpace = function() {
    return this.replace(/\s/g, '');
};

String.prototype.reduceWhiteSpace = function() {
    return this.replace(/\s+/g, ' ');
};

/* ========================================================================== */
/* ========================== NovyMail Model object ========================= */
/* ========================================================================== */

var NovyMail = {

    currency: 'Kč',
    package: null,
    period: 'monthly',
    companyRegistration: false,
    domainTransfer: false,
    domain: '',
    lookupCompanyUrl: '/rest/register/lookupCompany/',
    checkDomainUrl: '/rest/register/check/domain/',
    checkUsernameUrl: '/rest/register/check/username/',
    processOrderUrl: '/rest/register',

    setPackage: function(p) {
        if (typeof p != null && p != null) {
            this.package = p;
            console.log('Choosing package: '+this.package.name+'.');
        } else {
            this.package = this.pricingModel.starterPackage;
        }
    },

    pricingModel: {
        starterPackage: {
            name: 'starter',
            monthly: 59,
            quarterly: 59*3,
            yearly: 59*12
        },
        standardPackage: {
            name: 'standard',
            monthly: 1599,
            quarterly: 1599*3,
            yearly: 1599*11
        },
        professionalPackage: {
            name: 'professional',
            monthly: 2299,
            quarterly: 2299*3,
            yearly: 2299*11
        }
    },

    aresLookUp: function(ico) {
        if (typeof ico == 'undefined' || ico == '') {
            return false;
        }
        if (! /^[0-9]{8}$/.test(ico.killWhiteSpace())) {
            return false;
        }

        var url = this.lookupCompanyUrl;
        url += ico;
        return url;
    },

    checkDomain: function(domain) {
        if (typeof domain == 'undefined' || domain.length < 3) {
            return false;
        }
        if (! /^([a-zA-Z\-]{2,})(\.[a-zA-Z]{2,})$/.test(domain)) {
            return false;
        }

        var url = this.checkDomainUrl+domain;
        return url;
    },

    checkUsername: function(username) {

    },

    testEmail: function() { return 'test'; },
    testPassword: function() { return 'test123' }

}

/* ========================================================================== */
/* =========================== page specific functions ===================== */
/* ========================================================================== */

/* recalculate the final price */
function recalculate() {

    var p = 0;

    if (NovyMail.package != null) {
        switch (NovyMail.period) {            
            case 'quarterly':
                p = NovyMail.package.quarterly;
                break;
            case 'yearly':
                p = NovyMail.package.yearly;
                break;
            case 'monthly':
            default:
                p = NovyMail.package.monthly;
        }
    } else {
        p = NovyMail.pricingModel.starterPackage.monthly;
    }

    var c = parseInt($('#emailsCount').editable('getValue').emailsCount);

    if (c > 0 && c < 16 && 
        NovyMail.package.name == NovyMail.pricingModel.starterPackage.name) {        
        p = p * c;
    }

    $('#priceText').val(p + ',- ' + NovyMail.currency);
    $('#domainText').text(NovyMail.domain);

    // offers for you...
    
    $('.offer').addClass('hidden');

    if (NovyMail.package.name == NovyMail.pricingModel.standardPackage.name) {
        $('#freeAndroidTabletOffer').removeClass('hidden');
        $('#oneMonthFreeOffer').removeClass('hidden');
    }

    if (NovyMail.package.name == NovyMail.pricingModel.professionalPackage.name) {
        $('#freeAppleTabletOffer').removeClass('hidden');
        $('#oneMonthFreeOffer').removeClass('hidden');
    }

    if (!NovyMail.domainTransfer) {
        $('#freeDomainOffer').removeClass('hidden');
    }

    console.log(
        'package: '+NovyMail.package.name+' | '+
        'period: '+NovyMail.period+' | '+
        'count: '+c
    );

}

/* ========================================================================== */
/* ============================ jQuery onload functions ===================== */
/* ========================================================================== */

$(function() {

/* ========================================================================== */
    /* =============================== GENERAL SETUP ======================== */
/* ========================================================================== */    

//    $.fn.editable.defaults.mode = 'inline';

/* ========================================================================== */
    /* =============================== PAGE TOP NAV BAR ===================== */
/* ========================================================================== */
    $('.nav').localScroll({hash: true});

    $('#signUpMain').click(function () {
        $.scrollTo('#sign-up', 2000);
    });
    
    $('[rel="tooltip"]').tooltip();

    $('[href="#try-out"]').click(function(){
        $('#email').val(NovyMail.testEmail());
        $('#password').val(NovyMail.testPassword());
        $('#client').val('advanced');
        $('#loginForm').attr('target', '_blank').submit();        
    });

    $('[href="#try-out-simple"]').click(function(){
        $('#email').val(NovyMail.testEmail());
        $('#password').val(NovyMail.testPassword());
        $('#client').val('standard');
        $('#loginForm').attr('target', '_blank').submit();          
    });
    $('[href="#try-out-mobile"]').click(function(){
        $('#email').val(NovyMail.testEmail());
        $('#password').val(NovyMail.testPassword());
        $('#client').val('mobile');
        $('#loginForm').attr('target', '_blank').submit();        
    });

/* ========================================================================== */
/* ================= PACKAGES BUTTONS BASIC - STANDARD - PROFESSIONAL ======= */
/* ========================================================================== */

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
                $.scrollTo('#registerOne', 500);
                NovyMail.setPackage(NovyMail.pricingModel.starterPackage);
                $('#package').editable('setValue', NovyMail.package.name);
                $('#priceText').text(NovyMail.package.monthly+",- "+NovyMail.currency);
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
                $.scrollTo('#registerOne', 500);   
                NovyMail.setPackage(NovyMail.pricingModel.standardPackage);    
                $('#package').editable('setValue', NovyMail.package.name);
                $('#priceText').text(NovyMail.package.monthly+",- "+NovyMail.currency);
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
                $.scrollTo('#registerOne', 500);    
                NovyMail.setPackage(NovyMail.pricingModel.professionalPackage);  
                $('#package').editable('setValue', NovyMail.package.name);
                $('#priceText').text(NovyMail.package.monthly+",- "+NovyMail.currency);
            });
        }
    }); 

/* ========================================================================== */
/* ============= REGISTER FORM STEP ONE =================================== */
/* ========================================================================== */

    // store the data in the local storage in case there was an error
    // during the registration process and the browser went down
    // $('#registerForm').sisyphus(); 

    $('#domainInput').keyup(function() {
        $('#domainRegisterButton')
            .removeClass('btn-success').attr('disabled', 'disabled');
        $('#domainTransferButton')
            .removeClass('btn-success').attr('disabled', 'disabled');
        $('#domainFreeInfo').addClass('hidden');
        $('#domainTransferInfo').addClass('hidden');        
    });

    $('#domainInput').keyup(
        // try the domain verification
        $.debounce(300, function() {
            var req = NovyMail.checkDomain($('#domainInput').val());
            if (!req) {
                $('#registerTwo').addClass('hidden');
                $('#registerThree').addClass('hidden');
                return;
            }

            $.getJSON(req, function(data) {
                if (data.ok) {
                    
                    // the domain is free
                    $('#domainRegisterButton')
                        .addClass('btn-success').removeAttr('disabled');
                    $('#domainTransferButton')
                        .attr('disabled', 'disabled').removeClass('btn-success');
                    $('#domainFreeInfo').removeClass('hidden');
                    $('#domainTransferInfo').addClass('hidden');
                    NovyMail.domainTransfer = false;
                    
                    if (NovyMail.package != null 
                        && NovyMail.package.name == NovyMail.pricingModel.starterPackage.name) {
                        // user cannot register a domain and have monthly payment period
                        NovyMail.period = 'quarterly';
                        $('#period').editable('setValue', 'quarterly');
                    }

                } else {
                    
                    // the domain needs to be transferred
                    $('#domainRegisterButton')
                        .removeClass('btn-success').attr('disabled', 'disabled');
                    $('#domainTransferButton')
                        .addClass('btn-success').removeAttr('disabled');
                    $('#domainFreeInfo').addClass('hidden');
                    $('#domainTransferInfo').removeClass('hidden');
                    
                    NovyMail.domainTransfer = true;                    

                }
                NovyMail.domain = $('#domainInput').val();
                recalculate();
            });
        })
    );

    $('#domainRegisterButton').click(function() {
        if (!NovyMail.checkDomain($('#domainInput').val())) {
            $('#domainInput').focus();
            return;
        }
        $('#registerOneChevron')
            .removeClass('icon-chevron-up').addClass('icon-chevron-down');
        $('#registerTwo').removeClass('hidden');
        $('#registerThree').removeClass('hidden');
        $.scrollTo('#registerTwo', 500);
    });

    $('#domainTransferButton').click(function() {
        if (!NovyMail.checkDomain($('#domainInput').val())) {
            $('#domainInput').focus();
            return;
        }
        $('#registerOneChevron')
            .removeClass('icon-chevron-up').addClass('icon-chevron-down');
        $('#registerTwo').removeClass('hidden');
        $('#registerThree').removeClass('hidden');
        $.scrollTo('#registerTwo', 500);
    });



/* ========================================================================== */
/* ============= REGISTER FORM STEP TWO =================================== */
/* ========================================================================== */


    $('.register-editable').editable({

    });

    $('#emails').editable({
        select2: {
            tags: ['jmeno@prijmeni.cz', 'ivan.novak@seznam.cz'],
            tokenSeparators: [',', ' ']
        }
    })
    .on('save', function(e, params) {
        if (params.newValue.length > 0) { 
            $('#emailsCount').editable('setValue', params.newValue.length);
            recalculate();
        }        
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
    .keyup(function() {
        $('#registerCompanyButton')
            .removeClass('btn-primary').attr('disabled', 'disabled');
        $('#registerPersonButton')
            .removeClass('btn-primary').attr('disabled', 'disabled');
    })
    .keyup($.debounce(300, function() {

        var val = $('#customerInput').val();

        if(val.length < 4) {
            $('#registerCompanyButton')
                .removeClass('btn-primary').attr('disabled', 'disabled');
            $('#registerPersonButton')
                .removeClass('btn-primary').attr('disabled', 'disabled');                
            return;
        }
        
        var req = NovyMail.aresLookUp(val);
        
        if (!req) {
            if (val.length > 4) {
                console.log('Setting up personal account.');
                NovyMail.companyRegistration = false;
                var n = val.split(' ', 2);                
                if (n.length > 1) {
                    $('#name').editable('setValue', n[0]);
                    $('#surname')
                        .editable('setValue', val.substring(n[0].length).trim());
                } else {
                    $('#name').editable('setValue', val);
                    $('#surname').editable('setValue', null);
                }
            }
            $('#registerCompanyButton')
                .removeClass('btn-primary').attr('disabled', 'disabled');
            $('#registerPersonButton')
                .addClass('btn-primary').removeAttr('disabled');   
            
            NovyMail.companyRegistration = false;  

            return;
        }

        $.getJSON(req, function(d) {
            if (!d.ok) {

                $('#registerCompanyButton')
                    .removeClass('btn-primary').attr('disabled', 'disabled');
                $('#registerPersonButton')
                    .removeClass('btn-primary').attr('disabled', 'disabled');

            } else {

                $('#registerPersonButton')
                    .removeClass('btn-primary').attr('disabled', 'disabled');
                $('#registerCompanyButton')
                    .addClass('btn-primary').removeAttr('disabled');  
                NovyMail.companyRegistration = true;

                $('#company').editable('setValue', d.data.company != null ? d.data.company : '');
                $('#companyId').editable('setValue', d.data.companyId != null ? d.data.companyId : '');
                $('#vatNo').editable('setValue', d.data.vatNo != null ? d.data.vatNo : '');
                $('#name').editable('setValue', d.data.name != null ? d.data.name : '');
                $('#surname').editable('setValue', d.data.surname != null ? d.data.surname : '');
                $('#address').editable('setValue', 
                    {
                        street: d.data.street != null ? d.data.street : '', 
                        number: d.data.number != null ? d.data.number : '',
                        zip: d.data.zip != null ? d.data.zip : '',
                        district: d.data.district != null ? d.data.district : '',
                        city: d.data.city != null ? d.data.city : '', 
                        region: d.data.region != null ? d.data.region : '',
                        country: d.data.country != null ? d.data.country : ''            
                    }
                );
                
            }
        });
    }));
    

    $('#registerCompanyButton').click(function() {
        $('#registerTwoDetails').removeClass('hidden');
    });

    $('#registerPersonButton').click(function() {
        $('#registerTwoDetails').removeClass('hidden');
    });



/* ========================================================================== */
/* ============= REGISTER FORM STEP THREE ================================ */
/* ========================================================================== */


    $('#package').editable({        
        value: 'starter',
        source: [
            {value: 'starter', text: 'Starter 1 - 15 (placený za schránku)'},
            {value: 'standard', text: 'Standard 15 - 30 (placený paušálně)'},
            {value: 'professional', text: 'Professional 30 - 50 (placený paušálně)'}
        ],
        validate: function(value) {
            if (!NovyMail.domainTransfer && value == 'starter'
                && NovyMail.period == 'monthly') {
                // $('#period').editable('setValue', 'quarterly');
                return 'Cannot choose monthly billing for a new domain registration.';
            }       
        }
    })
    .on('hidden', function(e, params) {
        switch (params.newValue) {
            case 'standard':
                NovyMail.setPackage(NovyMail.pricingModel.standardPackage);
                break;
            case 'professional':
                NovyMail.setPackage(NovyMail.pricingModel.professionalPackage);
                break;
            case 'starter':
            default:
                NovyMail.setPackage(NovyMail.pricingModel.starterPackage);
        }
        recalculate();
    });

    $('#period').editable({        
        value: 'monthly',
        source: [
            {value: 'monthly', text: 'Měsíčně'},
            {value: 'quarterly', text: 'ˇCtvrtletně'},
            {value: 'yearly', text: 'Ročně (1 měsíc zdarma)'}
        ],
        validate: function(value) {
            if (!NovyMail.domainTransfer && value == 'monthly'
                && NovyMail.package.name == NovyMail.pricingModel.starterPackage.name) {
                // $('#period').editable('setValue', 'quarterly');
                return 'Cannot choose monthly billing for a new domain registration.';
            }
        }
    })
    .on('hidden', function(e, params) {
        NovyMail.period = $('#period').editable('getValue').period;
        recalculate();
    });    

    $('#emailsCount').on('save', function(e, params) {
        var val = $(this).editable('getValue');
        var p = NovyMail.package.name;
        if (val > 15 && p == NovyMail.pricingModel.starterPackage.name) {
            NovyMail.setPackage(NovyMail.pricingModel.standardPackage);            
        }
        if (val > 30 && p != NovyMail.pricingModel.professionalPackage.name) {
            NovyMail.setPackage(NovyMail.pricingModel.professionalPackage);
        }
        recalculate();
    });


});