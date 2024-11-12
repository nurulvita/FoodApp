package com.example.foodapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodapp.data.DataSource
import com.example.foodapp.data.FoodCategory
import com.example.foodapp.ui.theme.RedAccent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GridScreen(navController: NavController) {

    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    var selectedCategory by remember { mutableStateOf(FoodCategory.ALL) }

    val categories = FoodCategory.values()

    val foodList = DataSource.foodList
        .filter { food ->
            (food.name.contains(searchQuery.text, ignoreCase = true)) &&
                    (selectedCategory == FoodCategory.ALL || food.category == selectedCategory)
        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Menu Makanan", color = Color.White) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = RedAccent)
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = { Text("Cari Makanan") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(categories) { category ->
                        Button(
                            onClick = { selectedCategory = category },
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxWidth()
                                .clip(MaterialTheme.shapes.small),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (selectedCategory == category) Color(0xFFFFF9C4)
                                else MaterialTheme.colorScheme.surface,
                                contentColor = if (selectedCategory == category) Color.Black else MaterialTheme.colorScheme.onSurface
                            )
                        ) {
                            Text(text = category.name)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Food items grid
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(foodList) { food ->
                        Card(
                            modifier = Modifier
                                .padding(16.dp)
                                .clickable { navController.navigate("detail/${food.id}") },
                            shape = MaterialTheme.shapes.medium,
                            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Box {
                                Image(
                                    painter = painterResource(id = food.imageRes),
                                    contentDescription = food.name,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
                                        .clip(MaterialTheme.shapes.medium)
                                )

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .align(Alignment.BottomStart)
                                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.7f))
                                        .padding(8.dp)
                                ) {
                                    Text(
                                        text = food.name,
                                        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurface),
                                        maxLines = 1,
                                        modifier = Modifier.padding(horizontal = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}

