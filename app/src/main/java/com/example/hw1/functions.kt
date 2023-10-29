package com.example.hw1

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Screen(myList: SnapshotStateList<Int>, numberOfColumns: Int){
    LazyColumn(Modifier.fillMaxSize()) {
        item {
            CreateList(myList = myList, numberOfColumns = numberOfColumns)
        }
        item{
            Button(
                onClick = { myList.add(myList.size+1) }) {
                Text(text = stringResource(R.string.button),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun CreateList(myList: SnapshotStateList<Int>, numberOfColumns: Int){
    myList.chunked(numberOfColumns).forEach { chunk ->
        Row(Modifier.fillMaxWidth()){
            chunk.forEach { one ->
                val color = if (one % 2 == 0) Color.Red
                            else Color.Blue
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(4.dp)
                        .background(color)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = one.toString(),
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
private fun ScreenPreview(){
    val myList = remember { mutableStateListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12) }
    val numberOfColumns = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) 3 else 4
    Screen(myList, numberOfColumns)
}

