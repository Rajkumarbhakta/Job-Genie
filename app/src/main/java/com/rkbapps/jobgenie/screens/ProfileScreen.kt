package com.rkbapps.jobgenie.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.google.firebase.auth.FirebaseAuth
import com.rkbapps.jobgenie.model.Education
import com.rkbapps.jobgenie.model.Experience
import com.rkbapps.jobgenie.model.Skill


@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
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
        UserSkill(
            skillList = listOf(
                Skill(id = 1, name = "Java"),
                Skill(id = 2, name = "Kotlin"),
                Skill(id = 3, name = "Python"),
                Skill(id = 4, name = "C++"),
                Skill(id = 5, name = "C"),
                Skill(id = 6, name = "Javascript"),
                Skill(id = 7, name = "React"),
                Skill(id = 8, name = "Angular"),
            )
        )

        UserExperience(
            experienceList = listOf(
                Experience(
                    id = 1,
                    company = "Google",
                    startDate = "2018",
                    endDate = "2020",
                    title = "Software Engineer",
                ),
                Experience(
                    id = 2,
                    company = "Facebook",
                    startDate = "2018",
                    endDate = "2020",
                    title = "Software Engineer",
                ),
                Experience(
                    id = 3,
                    company = "Amazon",
                    startDate = "2018",
                    endDate = "2020",
                    title = "Software Engineer",
                ),

                )
        )

    }
}


@Composable
fun ProfileTopBar(firstName: String, lastName: String, email: String) {
    val user = FirebaseAuth.getInstance().currentUser
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(1.dp)
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
                Text(text = user!!.email!!, fontSize = 15.sp, fontWeight = FontWeight.Normal)
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
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Education",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .weight(1f)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add education")
            }
        }
        if (educationList.isEmpty()) {
            Text(
                text = "No education added",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        } else {
            educationList.forEach {
                EducationItem(education = it)
            }
        }

    }
}

@Composable
fun EducationItem(education: Education) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 8.dp)
        ) {
            Text(text = education.degree, style = MaterialTheme.typography.titleSmall)
            Text(text = education.school, style = MaterialTheme.typography.bodyMedium)
            Text(text = education.startYear, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun UserSkill(skillList: List<Skill>) {
    Column(
        verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Skills",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add skill")
            }
        }
        if (skillList.isEmpty()) {
            Text(
                text = "No skill added",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                skillList.forEach {
                    SkillItem(skill = it)
                }
            }
        }
    }

}

@Composable
fun SkillItem(skill: Skill) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .border(1.dp, Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = skill.name, style = MaterialTheme.typography.titleSmall)
        }
    }
}

@Composable
fun UserExperience(experienceList: List<Experience>) {
    Column(
        verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Experience",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Experience")
            }
        }
        if (experienceList.isEmpty()) {
            Text(
                text = "No experience added",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        } else {
                experienceList.forEach {
                    ExperienceItem(experience = it)
                }
        }
    }
}

@Composable
fun ExperienceItem(experience: Experience) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 8.dp)
        ) {
            Text(text = experience.title, style = MaterialTheme.typography.titleSmall)
            Text(text = experience.company, style = MaterialTheme.typography.bodyMedium)
            Text(text = experience.startDate, style = MaterialTheme.typography.bodyMedium)
        }
    }
}






