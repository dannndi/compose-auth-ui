package com.dannndi.composeui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dannndi.composeui.PrimaryTextField
import com.dannndi.composeui.R
import com.dannndi.composeui.SocialLogin

@Composable
fun LoginPage(navController: NavController) {
    // in this we'll need 2 value for email and password
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_auth_1),
                contentDescription = "Login Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(vertical = 16.dp),
            )
            Text(
                "Login",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )
            PrimaryTextField(
                value = email,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Email,
                ),
                singleLine = true,
                maxLines = 1,
                label = { Text("Email", color = Color.LightGray) },
                leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = "Email Icon") },
                onValueChange = { email = it }
            )
            PrimaryTextField(
                value = password,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Email,
                ),
                singleLine = true,
                maxLines = 1,
                label = { Text("Password", color = Color.LightGray) },
                leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = "Email Icon") },
                trailingIcon = {
                    Text(
                        "Forgot ?",
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .clickable { }
                            .padding(10.dp)
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = { password = it }
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 45.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentPadding = PaddingValues(vertical = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                )
            ) {
                Text("Login", color = Color.White)
            }
            Text(
                "Or",
                color = Color.LightGray,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(vertical = 15.dp)
            )
            SocialLogin()
            Row {
                Text(
                    "New to this App ?",
                    color = Color.LightGray,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(vertical = 25.dp)
                )
                Text(
                    "Register Here !",
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .padding(vertical = 25.dp, horizontal = 10.dp)
                        .clickable {
                            navController.navigate("/register-page")
                        }
                )
            }
        }
    }
}