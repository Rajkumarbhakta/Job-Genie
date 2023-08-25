package com.rkbapps.jobgenie.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.rkbapps.jobgenie.model.Education


@Composable
fun ProfileScreen(navController: NavHostController) {
    Column {
        ProfileTopBar(firstName = "Rahul", lastName = "Kumar", email = "rajkumar@gmail.com")
        EducationQualificationItem(
            educationList = listOf(
                Education(
                    degree = "B.Tech",
                    school = "NIT Patna",
                    startYear = "2016",
                    endYear = "2020",
                    id = 1
                ),
                Education(
                    degree = "M.Tech",
                    school = "IIT Bombay",
                    startYear = "2018",
                    endYear = "2020",
                    id = 2
                )
            )
        )

        Button(onClick = {
            Firebase.auth.signOut()
        }) {
            Text(text = "Logout")
        }

    }
}

@Composable
fun ProfileTopBar(firstName: String, lastName: String, email: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
                Text(
                    text = "$firstName $lastName",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(text = email, fontSize = 15.sp, fontWeight = FontWeight.Normal)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(shape = RoundedCornerShape(50))
                    .background(MaterialTheme.colorScheme.secondary)
            ) {
                Text(
                    text = "${firstName[0]}${lastName[0]}",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@Composable
fun EducationQualificationItem(educationList: List<Education>) {
    Column(
        verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Education",
            style = MaterialTheme.typography.headlineMedium
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(educationList.size) {
                EducationItem(education = educationList[it])
            }
        }
    }
}

@Composable
fun EducationItem(education: Education) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth(),
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        shape = RoundedCornerShape(10.dp),
//        elevation = CardDefaults.cardElevation(2.dp)
//    ) {
//        Column(modifier = Modifier.padding(10.dp)) {
//            Text(text = education.degree, style = MaterialTheme.typography.titleSmall)
//            Text(text = education.school, style = MaterialTheme.typography.bodyMedium)
//            Text(text = education.startYear, style = MaterialTheme.typography.bodyMedium)
//        }
//    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 2.dp, color = Color.Black)
            .padding(10.dp)
    ) {
        Text(text = education.degree, style = MaterialTheme.typography.titleSmall)
        Text(text = education.school, style = MaterialTheme.typography.bodyMedium)
        Text(text = education.startYear, style = MaterialTheme.typography.bodyMedium)
    }
}



