package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                        LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm() {

    var username: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    val formModifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
    Column() {
        Text(
            text = "Login",
            color= MaterialTheme.colors.primary,
            style= MaterialTheme.typography.h4,
            modifier = formModifier.padding(top = 12.dp)
        )
        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            label = { Text(text = "Username")},
            placeholder = {Text(text = "abc@email.com")},
            singleLine = true,
            trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon" )},
            modifier =  formModifier

        )
        OutlinedTextField(
            value = password ,
            onValueChange = {password = it},
            trailingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon")},
            label = { Text(text = "Password")},
            placeholder = { Text(text = "enter password")},
            singleLine = true,
            modifier =  formModifier,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),


        )
        Button(
            onClick = { /*TODO*/ },
            modifier = formModifier
        ) {
            Text(
                text = "Submit",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5
            )

        }

    }

}