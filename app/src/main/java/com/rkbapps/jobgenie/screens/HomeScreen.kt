package com.rkbapps.jobgenie.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rkbapps.jobgenie.model.JobItem
import com.rkbapps.jobgenie.model.JobList

@Composable
fun HomeScreen(navController: NavHostController) {
//    val viewModel: HomeScreenViewModel = hiltViewModel()
//    val jobList = viewModel.jobListing.collectAsState()
    val jobList = jobListingDummyList()

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }
    }) {
        if (!jobList.jobListings.isNullOrEmpty()) {
            LazyColumn(modifier = Modifier.padding(it)) {
                items(jobList.jobListings) { job ->
                    JobItem(job)
                }
            }
        } else {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "No Jobs Found", style = MaterialTheme.typography.bodyMedium)
            }
        }

    }

}

@Composable
fun JobItem(job: JobItem) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp),
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = job.title, style = MaterialTheme.typography.titleMedium)
                Text(text = job.location, style = MaterialTheme.typography.bodyMedium)
                Text(text = job.posted_at, style = MaterialTheme.typography.bodySmall)
            }

        }
    }
}

fun jobListingDummyList(): JobList {
    return JobList(
        currentPage = 0,
        last = true,
        totalItems = 0,
        totalPages = 0,
        jobListings = listOf(
            JobItem(
                id = 1,
                title = "Android Developer",
                location = "Kolkata",
                posted_at = "2 days ago",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl.",
            ),
            JobItem(
                id = 2,
                title = "Android Developer",
                location = "Kolkata",
                posted_at = "2 days ago",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl.",
            ),
            JobItem(
                id = 3,
                title = "Android Developer",
                location = "Kolkata",
                posted_at = "2 days ago",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl.",
            ),
            JobItem(
                id = 4,
                title = "Android Developer",
                location = "Kolkata",
                posted_at = "2 days ago",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl.",
            ),
            JobItem(
                id = 5,
                title = "Android Developer",
                location = "Kolkata",
                posted_at = "2 days ago",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl.",
            ),
            JobItem(
                id = 6,
                title = "Android Developer",
                location = "Kolkata",
                posted_at = "2 days ago",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl.",
            ),
            JobItem(
                id = 7,
                title = "Android Developer",
                location = "Kolkata",
                posted_at = "2 days ago",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl.",
            ),
            JobItem(
                id = 8,
                title = "Android Developer",
                location = "Kolkata",
                posted_at = "2 days ago",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl. Nulla euismod, nisl eget ultricies ultrices, nisl nisl aliquam nisl, eget aliquam nisl nisl eget nisl.",
            ),


        )

    )
}
