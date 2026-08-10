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
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.campuslostandfound.firebase.AuthRepository
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.remember
import com.example.campuslostandfound.data.local.DatabaseProvider
import com.example.campuslostandfound.data.repository.UserRepository
@Composable
fun LoginScreen(navController:NavController){
    val context = LocalContext.current

    val database = DatabaseProvider.getDatabase(context)

    val authRepository = remember {
        AuthRepository()
    }

    val userRepository = remember {
        UserRepository(database.userDao())
    }

    val loginViewModel: LoginViewModel = viewModel(
        factory = LoginViewModelFactory(
            authRepository = authRepository,
            userRepository = userRepository
        )
    )
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
                if(email.isBlank()){
                    Toast.makeText(
                        context,
                        "Enter your email",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }
                if(password.isBlank()){
                    Toast.makeText(
                        context,
                        "Enter your password",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }
                loginViewModel.login(
                    email = email,
                    password = password,

                    onSuccess = {

                        Toast.makeText(
                            context,
                            "Login successful",
                            Toast.LENGTH_SHORT
                        ).show()

                        navController.navigate(Routes.HOME) {
                            popUpTo(Routes.LOGIN) {
                                inclusive = true
                            }
                        }
                    },

                    onFailure = { error ->

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