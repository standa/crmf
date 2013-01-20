/**
Address editable input.
Internally value stored as {city: "Moscow", street: "Lenina", building: "15"}

@class address
@extends abstractinput
@final
@example
<a href="#" id="address" data-type="address" data-pk="1">awesome</a>
<script>
$(function(){
    $('#address').editable({
        url: '/post',
        title: 'Enter city, street and building #',
        value: {
            street: "Lenina", 
            number: "15",
            zip: "124356",
            district: "Browning",
            city: "Moscow", 
            region: "Highlands",
            country: "England"            
        }
    });
});
</script>
**/
(function ($) {
    var Address = function (options) {
        this.init('address', options, Address.defaults);
    };

    //inherit from Abstract input
    $.fn.editableutils.inherit(Address, $.fn.editabletypes.abstractinput);

    $.extend(Address.prototype, {
        /**
        Renders input from tpl

        @method render() 
        **/        
        render: function() {
           this.$input = this.$tpl.find('input');
        },
        
        /**
        Default method to show value in element. Can be overwritten by display option.
        
        @method value2html(value, element) 
        **/
        value2html: function(value, element) {
            if(!value) {
                $(element).empty();
                return; 
            }
            var html = $('<div>').text(value.street+' '+value.number+', ').html() + 
            		$('<div>').text(value.district+', ').html() +
            		$('<div>').text(value.zip+' '+value.city+', ').html() +
            		$('<div>').text(value.region+', ').html() +
            		$('<div>').text(value.country).html();
            $(element).html(html); 
        },
        
        /**
        Gets value from element's html
        
        @method html2value(html) 
        **/        
        html2value: function(html) {        
          /*
            you may write parsing method to get value by element's html
            e.g. "Moscow, st. Lenina, bld. 15" => {city: "Moscow", street: "Lenina", building: "15"}
            but for complex structures it's not recommended.
            Better set value directly via javascript, e.g. 
            editable({
                value: {
                    city: "Moscow", 
                    street: "Lenina", 
                    building: "15"
                }
            });
          */ 
          return null;  
        },
      
       /**
        Converts value to string. 
        It is used in internal comparing (not for sending to server).
        
        @method value2str(value)  
       **/
       value2str: function(value) {
           var str = '';
           if(value) {
               for(var k in value) {
                   str = str + k + ':' + value[k] + ';';  
               }
           }
           return str;
       }, 
       
       /*
        Converts string to value. Used for reading value from 'data-value' attribute.
        
        @method str2value(str)  
       */
       str2value: function(str) {
           /*
           this is mainly for parsing value defined in data-value attribute. 
           If you will always set value by javascript, no need to overwrite it
           */
           return str;
       },                
       
       /**
        Sets value of input.
        
        @method value2input(value) 
        @param {mixed} value
       **/         
       value2input: function(value) {
          if (typeof value != 'undefined' && value != null) {
            this.$input.filter('[name="street"]').val(value.street);
            this.$input.filter('[name="number"]').val(value.number);
            this.$input.filter('[name="district"]').val(value.district);
            this.$input.filter('[name="zip"]').val(value.zip);            
            this.$input.filter('[name="city"]').val(value.city);
            this.$input.filter('[name="region"]').val(value.region);
            this.$input.filter('[name="country"]').val(value.country);
          }
       },       
       
       /**
        Returns value of input.
        
        @method input2value() 
       **/          
       input2value: function() { 
           return {
           		street: this.$input.filter('[name="street"]').val(),
           		number: this.$input.filter('[name="number"]').val(),
              district: this.$input.filter('[name="district"]').val(),
           		zip: this.$input.filter('[name="zip"]').val(),              
           		city: this.$input.filter('[name="city"]').val(), 
              region: this.$input.filter('[name="region"]').val(),               
              country: this.$input.filter('[name="country"]').val()
           };
       },        
       
        /**
        Activates input: sets focus on the first field.
        
        @method activate() 
       **/        
       activate: function() {
            this.$input.filter('[name="street"]').focus();
       },  
       
       /**
        Attaches handler to submit form in case of 'showbuttons=false' mode
        
        @method autosubmit() 
       **/       
       autosubmit: function() {
           this.$input.keydown(function (e) {
                if (e.which === 13) {
                    $(this).closest('form').submit();
                }
           });
       }       
    });

    Address.defaults = $.extend({}, $.fn.editabletypes.abstractinput.defaults, {
        tpl: '<div class="editable-address"><label><span>Ulice: </span><input type="text" name="street" class="input-small"></label></div>'+
		         '<div class="editable-address"><label><span>ˇC.p./ˇC.o.: </span><input type="text" name="number" class="input-small"></label></div>'+             
             '<div class="editable-address"><label><span>Město: </span><input type="text" name="city" class="input-small"></label></div>'+
             '<div class="editable-address"><label><span>PSˇC: </span><input type="text" name="zip" class="input-small"></label></div>'+             
						 '<div class="editable-address"><label><span>ˇCtvr´t: </span><input type="text" name="district" class="input-small"></label></div>'+
						 '<div class="editable-address"><label><span>Kraj: </span><input type="text" name="region" class="input-small"></label></div>'+						
             '<div class="editable-address"><label><span>Stát: </span><input type="text" name="country" class="input-mini"></label></div>',
             
        inputclass: ''
    });

    $.fn.editabletypes.address = Address;

}(window.jQuery));
