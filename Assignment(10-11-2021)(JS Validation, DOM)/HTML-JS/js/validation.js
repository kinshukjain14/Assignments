function validateSignInUserInput()
{
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var p = document.getElementById("message");

    if(username.value == "" || username.value == " "){
        p.innerText="*username is required";
        username.style.border = "2px Solid red";
        return false;
    }
    else{
        p.innerText="";
        username.style.border = "0px";

    }
    if(password.value == "" || username.value == " "){
        p.innerText="*password is required";
        password.style.border = "2px Solid red";
        return false;
    }else{
        p.innerText="";
        password.style.border = "0px";
    }
    return true;
}

function validateSignUpUserInput()
{
    var flag=true;
    var firstname = document.getElementById("firstname");
    var lastname = document.getElementById("lastname");
    var contact = document.getElementById("contact");
    var email = document.getElementById("email");
    var password = document.getElementById("password");
    var cnfpassword = document.getElementById("cnfpassword");
    var p=document.getElementById("message");
    
        if(firstname.value == "" || firstname.value == " "){
            firstname.style.border="2px solid red";
            flag=false;
        }
        else{
            firstname.style.border="0px solid red";
            flag=true;
        }
        if(lastname.value == "" || lastname.value==" "){
            lastname.style.border="2px solid red";
            flag=false;
        }
        else{
            lastname.style.border="0px solid red";
            flag=true;
        }
        if(contact.value=="" || contact.value==" "){
            contact.style.border="2px solid red";
            flag=false;
        }
        else{
            contact.style.border="0px solid red";
            flag=true;
        }
        if(email.value=="" || email.value==" "){
            email.style.border="2px solid red";
            flag=false;
        }
        else{
            email.style.border="0px solid red";
            flag=true;
        }
        if(password.value=="" || password.value==" "){
            password.style.border="2px solid red";
            flag=false;
        }
        else{
            password.style.border="0px solid red";
            flag=true;
        }
        if(cnfpassword.value=="" || cnfpassword.value==" "){
            cnfpassword.style.border="2px solid red";
            flag=false;
        }
        else{
            cnfpassword.style.border="0px solid red";
            flag=true;
        }
        if(!flag){
            p.innerText="*Fields are required";
            return flag;
        }

        if(validateName(firstname.value)){
            firstname.style.border="0px solid red";
            p.innerText="";
            flag=true;
        }
        else{
            firstname.style.border="2px solid red";
            flag=false;
        }
        
        if(!flag){
            p.innerText="*Enter valid name";
            return flag;
        }

        if(validateName(lastname.value)){
            lastname.style.border="0px solid red";
            p.innerText="";
            flag=true;
        }
        else{
            lastname.style.border="2px solid red";
            p.innerText="*Enter valid name";
            flag=false;
        }
        if(validateContact(contact.value)){
            contact.style.border="0px solid red";
            p.innerText="";
            flag=true;
        }
        else{
            contact.style.border="2px solid red";
            p.innerText="*Enter valid contact number";
            flag=false;
        }
        if(validateEmail(email.value)){
            email.style.border="0px solid red";
            p.innerText="";
            flag=true;
        }
        else{
            email.style.border="2px solid red";
            p.innerText="*Enter valid email id";
            flag=false;
        }
        if(validatePassword(password.value,cnfpassword.value)){
            cnfpassword.style.border="0px solid red";
            p.innerText="";
            flag=true;
        }
        else{
            cnfpassword.style.border="2px solid red";
            p.innerText="*Confirm Password does not match";
            flag=false;
        }
        if(validatePasswordPolicy(password.value)){
            password.style.border="0px solid red";
            p.innerText="";
            flag=true;
        }
        else{
            cnfpassword.style.border="2px solid red";
            p.innerText="*Password is not as per policy";
            flag=false;
        }
        return flag;
};

var validateName = (name)=>{
    var regex='[A-Z][a-z]*';
    return validate(name,regex);
};

var validateEmail = (email)=>{
    var regex = "[A-Za-z0-9+_.-]+@[a-z]+[.][a-z]+{2,3}$";
    return validate(email,regex);
};

var validateContact = (contact)=>{
    var regex = "^[6-9][0-9]{9}";
    return validate(contact,regex);
};

var validatePasswordPolicy = (password)=>{
    var regex = "^(?=.*[0-9])"
    + "(?=.*[a-z])(?=.*[A-Z])"
    + "(?=.*[@#$%^&+=])"
    + "(?=\\S+$).{8,20}$";
    return validate(password,regex);
}

var validatePassword = (password,cnfpassword)=>{
    return password == cnfpassword;
};

var validate = (string,regex)=>{
    return regex.test(string);
};