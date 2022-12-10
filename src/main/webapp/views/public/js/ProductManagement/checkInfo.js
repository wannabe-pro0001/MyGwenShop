let specialCharacters = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
function checkInfoInput (){
    Validator({
        form: '#form-inforProduct',
        errorSelector: '.form-message',
        listImage: '#form-inforProduct__image .list-image .image-item_wrapper',
        rules: [
            Validator.isNumber(document.querySelector('#product_amount input'), "0-9"),
            Validator.isCharacters(document.querySelectorAll("#product_size input"), 'a-z A-Z'),
            Validator.isCharacters(document.querySelectorAll("#product_color input"), 'a-z A-Z'),
            Validator.isProductName(document.querySelector("#form-inforProduct__infor #product_name"), 'không chứa ký tự đặc biệt hoặc không để trống'),
            Validator.isNumber(document.querySelector("#form-inforProduct__infor #product_price"), '0-9'),
        ],
        onsubmit: function(){}
    });

}

Validator.isCharacters = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return (value.trim().length == 0 || specialCharacters.test(value) || /[0-9]/.test(value))? message : undefined
        }
    };
}

Validator.isNumber = function(selector, message){
    return{
        selector: selector,
        test: function(value){
            return (specialCharacters.test(value) || /[a-zA=Z]/.test(value) || value.trim().length == 0 || value.trim()[0] == '0')?  message : undefined
        }
    }
}
Validator.isProductName = function(selector, message){
    return {
        selector: selector,
        test: function (value) {
            return (value.trim().length == 0 || specialCharacters.test(value))? message : undefined
        }
    };
}
