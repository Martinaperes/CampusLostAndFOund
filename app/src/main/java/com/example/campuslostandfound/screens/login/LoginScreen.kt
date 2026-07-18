package com.example.campuslostandfound.screens.login

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
import com.example.campuslostandfound.navigation.Routes

@Composable
fun LoginScreen(navController:NavController){
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text="Welcome Back!",
            style=MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier=Modifier.height(24.dp))
        OutlinedTextField(
            value=email,
            onValueChange={email=it},
            label={
                Text("Email")
            }
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
        Button(
            onClick = {
                //Login code will go here
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
                text="LOGIN",
                color=Color.White
            )
        }
        Spacer(modifier=Modifier.height(16.dp))
        Text("Don't have an account?")
        TextButton(
            onClick={
                navController.navigate(Routes.REGISTER)
            }
        ){
            Text(
                text="Register",
                color=PrimaryGreen
            )
        }
    }

}