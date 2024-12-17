package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        fullName = stringResource(R.string.full_name),
                        jobTitle = stringResource(R.string.job_title),
                        telephone = stringResource(R.string.telephone),
                        social = stringResource(R.string.social_handle),
                        email = stringResource(R.string.email),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(fullName: String, jobTitle: String, telephone: String, social: String, email: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xffbed2c0))
    ) {
        Column (
            modifier = Modifier
                .padding(top = 20.dp)
                .wrapContentSize(Alignment.Center)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .background(Color(0xff073042))
                    .size(100.dp)
            )
            Text(
                text = fullName,
                fontSize = 30.sp
            )
            Text(
                text = jobTitle,
                color = Color(0xFF439067),
                fontWeight = FontWeight.Bold
            )
        }
        Column (
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
        ){
            Row {
                Icon(
                    Icons.Rounded.Call,
                    contentDescription = null,
                    tint = Color(0xff439067)
                )
                Text(
                    text = telephone,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            Row {
                Icon(
                    Icons.Rounded.Share,
                    contentDescription = null,
                    tint = Color(0xff439067)
                )
                Text(
                    text = social,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            Row {
                Icon(
                    Icons.Rounded.Email,
                    contentDescription = null,
                    tint = Color(0xff439067)
                )
                Text(
                    text = email,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        }
    }



@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            fullName = stringResource(R.string.full_name),
            jobTitle = stringResource(R.string.job_title),
            telephone = stringResource(R.string.telephone),
            social = stringResource(R.string.social_handle),
            email = stringResource(R.string.email)
        )
    }
}