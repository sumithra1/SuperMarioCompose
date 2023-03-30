package com.example.supermariocompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.domain.entity.Amiibo
import com.example.mvvmcleanarchidemo1.viewmodels.GameViewModel



@Composable
fun GamesListItem(viewModel: GameViewModel = hiltViewModel()) {
  // val res = viewModel.getGamesData()
//    LazyColumn(){
//       viewModel.gamesDetails.value.let { it ->
//           if (it != null) {
//               items(it.amiibo){
//                    listItem(amiibo = it)
//               }
//           }
//       }
//    }
    val res = viewModel.games

    //val demo =viewModel.gamesDatas
    LazyColumn{
        res.value.data?.let {
            items(it) {
                listItem(it)
            }

        }

    }
}
@Composable
fun listItem(amiibo: Amiibo){
    Row() {
                Image(painter = rememberImagePainter(data =amiibo.image), contentDescription =null
                , modifier = Modifier
                        .padding(top = 50.dp, start = 20.dp, bottom = 10.dp)
                        .size(100.dp)
                        .clip(CircleShape))

        Column {
            Text(text = amiibo.name, fontSize = 18.sp, fontFamily = FontFamily.Serif
            , fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 60.dp,end=10.dp, start = 30.dp)
            )
            Text(text = amiibo.amiiboSeries, fontSize = 16.sp, fontFamily = FontFamily.Serif, fontWeight = FontWeight.Medium, modifier = Modifier.padding(top=10.dp, end = 10.dp, start = 30.dp))
        }
            }






}