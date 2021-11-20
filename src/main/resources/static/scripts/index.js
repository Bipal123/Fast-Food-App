const logInPage =document.getElementById('jumbotronLogIn');
const signUpPage=document.getElementById('jumbotronSignUp');
const signUpText=document.getElementById('signUp');
const logInText1=document.getElementById('logIn1');
const signUpText1=document.getElementById('signUp1');

signUpPage.classList.add('d-none');

signUpText.addEventListener("click",function(){
    signUpPage.classList.remove('d-none');
    logInPage.classList.add('d-none');
})

logInText1.addEventListener("click",function(){
    signUpPage.classList.add('d-none');
    logInPage.classList.remove('d-none');
})

signUpText1.addEventListener("click",function(){
    signUpPage.classList.remove('d-none');
    logInPage.classList.add('d-none');
})