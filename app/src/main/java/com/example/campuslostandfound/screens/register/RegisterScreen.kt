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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.campuslostandfound.data.local.DatabaseProvider
import com.example.campuslostandfound.data.repository.UserRepository


@Composable
fun RegisterScreen(navController: NavController) {

    val context = LocalContext.current

    val database = DatabaseProvider.getDatabase(context)

    val authRepository = remember {
        AuthRepository()
    }

    val userRepository = remember {
        UserRepository(database.userDao())
    }

    val registerViewModel: RegisterViewModel = viewModel(
        factory = RegisterViewModelFactory(
            authRepository = authRepository,
            userRepository = userRepository
        )
    )
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
    var registrationNumber by remember {
        mutableStateOf("")
    }

    var department by remember {
        mutableStateOf("")
    }

    var phoneNumber by remember {
        mutableStateOf("")
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
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = registrationNumber,
            onValueChange = {
                registrationNumber = it
            },
            label = {
                Text("Registration Number")
            },
            placeholder = {
                Text("e.g. SCCJ/00632/2023")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = department,
            onValueChange = {
                department = it
            },
            label = {
                Text("Department")
            },
            placeholder = {
                Text("e.g. Computing and IT")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
            },
            label = {
                Text("Phone Number")
            },
            placeholder = {
                Text("e.g. 0716052342")
            },
            modifier = Modifier.fillMaxWidth()
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
                if (registrationNumber.isBlank()) {
                    Toast.makeText(
                        context,
                        "Please enter your registration number",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }

                if (department.isBlank()) {
                    Toast.makeText(
                        context,
                        "Please enter your department",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }

                if (phoneNumber.isBlank()) {
                    Toast.makeText(
                        context,
                        "Please enter your phone number",
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
                registerViewModel.register(
                    email = email,
                    password = password,
                    registrationNumber = registrationNumber,
                    name = fullName,
                    department = department,
                    phoneNumber = phoneNumber,

                    onSuccess = {
                        Toast.makeText(
                            context,
                            "Registration successful",
                            Toast.LENGTH_SHORT
                        ).show()

                        navController.navigate(Routes.LOGIN) {
                            popUpTo(Routes.REGISTER) {
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