package com.example.loginpage

import android.content.Context
import android.graphics.fonts.FontFamily
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily.Companion.Monospace
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginUi(applicationContext)
        }
    }
}

@Composable
fun LoginUi(context: Context) {
    var email by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp, bottom = 100.dp, start = 25.dp, end = 25.dp),
            

    ) {
        
        Text(
            text = "Login Here",
            fontFamily = Monospace,
            fontSize = 20.sp,
            textAlign = Center,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Enter your Username") },
            leadingIcon = {
                Icon(
                    Icons.Default.Person, contentDescription = "person"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter Password") },
            leadingIcon = {
                Icon(
                    Icons.Default.Lock, contentDescription = "lock"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        OutlinedButton(
            onClick = { logged(email, password, context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        ) {
                Text(
                    text = "Login",
                    textAlign = Center,
                )
        }



    }

}

fun logged(email: String, password: String, context: Context) {
        if(email == "Student" && password == "1234"){
            Toast.makeText(context, "Logged In Successfully", Toast.LENGTH_SHORT).show()
        }
        else if(email == "" || password == ""){
            Toast.makeText(context, "The Field is empty, Please Recheck", Toast.LENGTH_SHORT).show()
        }

        else{
            Toast.makeText(context, "Logged In Failed", Toast.LENGTH_SHORT).show()
        }
}