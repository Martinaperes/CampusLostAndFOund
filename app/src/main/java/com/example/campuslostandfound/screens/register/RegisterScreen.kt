package com.example.campuslostandfound.screens.register

import androidx.compose.foundation.gestures.draggable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import com.example.campuslostandfound.ui.theme.PrimaryGreen
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.campuslostandfound.firebase.AuthRepository
import com.example.campuslostandfound.navigation.Routes
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

@Composable
fun RegisterScreen(navController:NavController){
    val context = LocalContext.current
    var fullName by remember{
        mutableStateOf("")
    }
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    var confirmpassword by remember{
        mutableStateOf("")
    }
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    var confirmPasswordVisible by remember {
        mutableStateOf(false)
    }
    val authRepository=remember {
        AuthRepository()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text="Create Account",
            style=MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier=Modifier.height(24.dp))
        OutlinedTextField(
            value=fullName,
            onValueChange={fullName=it},
            label={
                Text("Full Name")
            },
            modifier=Modifier.fillMaxWidth()
        )
        Spacer(modifier=Modifier.height(16.dp))
        OutlinedTextField(
            value=email,
            onValueChange={email=it},
            label={
                Text("Email")
            },
            modifier=Modifier.fillMaxWidth()
        )
        Spacer(modifier=Modifier.height(16.dp))
        OutlinedTextField(
            value=password,
            onValueChange = {password=it},
            label={
                Text("Password")
            },
            visualTransformation =
                if(passwordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick={
                    passwordVisible=!passwordVisible
                }) {
                    Icon(
                        imageVector=
                            if(passwordVisible)
                                Icons.Default.Visibility
                            else
                                Icons.Default.VisibilityOff,
                        contentDescription="Toggle password visibility"

                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier=Modifier.height(24.dp))
        OutlinedTextField(
            value=confirmpassword,
            onValueChange = {confirmpassword=it},
            label={
                Text("Confirm Password")
            },
            visualTransformation =
                if(confirmPasswordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick={
                    confirmPasswordVisible=!confirmPasswordVisible
                }) {
                    Icon(
                        imageVector=
                            if(confirmPasswordVisible)
                                Icons.Default.Visibility
                            else
                                Icons.Default.VisibilityOff,
                        contentDescription="Toggle password visibility"

                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier=Modifier.height(24.dp))
        Button(
            onClick = {
                if(fullName.isBlank()){
                    Toast.makeText(
                        context,
                        "Pleas enter your full name",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }
                if(email.isBlank()){
                    Toast.makeText(
                        context,
                        "Enter the email",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }
                if(password.isBlank()){
                    Toast.makeText(
                        context,
                        "Please enter your password!",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }
                if(confirmpassword.isBlank()){
                    Toast.makeText(
                        context,
                        "Please enter the right password",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }
                if(password != confirmpassword){
                    Toast.makeText(
                        context,
                        "Passwords do not match",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }
                if(password.length<8){
                    Toast.makeText(
                        context,
                        "Password must be atleast 8 characters",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }
                if(!password.any{!it.isLetterOrDigit()}){
                    Toast.makeText(
                        context,
                        "Password must contain atleast one special character",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }
                authRepository.registerUser(
                    email=email,
                    password=password,
                    onSuccess = {
                        Toast.makeText(
                            context,
                            "Registration successful",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.navigate(Routes.LOGIN)
                    },
                    onFailure = {error->
                        Toast.makeText(
                            context,
                            error,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                )
            },
            modifier= Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape=RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryGreen
            )
        ){
            Text(
                text="CREATE ACCOUNT",
                color=Color.White
            )
        }
        Spacer(modifier=Modifier.height(16.dp))
        Row(modifier= Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
        Text("Already have an account?")
        TextButton(
            onClick={
                navController.navigate(Routes.LOGIN)
            }
        ) {
            Text(
                text = "Login",
                color = PrimaryGreen
            )
        }
        }
    }

}