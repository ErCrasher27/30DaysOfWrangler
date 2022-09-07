package com.example.thirtydaysofwrangler

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.thirtydaysofwrangler.model.Wrangler


@Composable
fun WranglerCard(wrangler: Wrangler, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = 8.dp,
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,

        ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(10.dp)
                .fillMaxSize()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessVeryLow
                    )
                )
        ) {
            Text(
                modifier = modifier.align(Alignment.Start),
                text = stringResource(id = wrangler.day),
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.primary
            )
            Text(
                modifier = modifier.align(Alignment.Start),
                text = stringResource(id = wrangler.location),
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.secondary
            )
            Spacer(modifier = modifier.height(10.dp))
            ImageWrangler(wrangler.wrangler, wrangler.day)
            WranglerItemButton(expanded = expanded, onClick = {
                expanded = !expanded
            })
            if (expanded) {
                Text(
                    modifier = modifier.align(Alignment.Start),
                    text = stringResource(id = wrangler.description),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.secondary
                )
            }

        }
    }
}

@Composable
fun ImageWrangler(wranglerImageId: Int, wranglerDayId: Int) {
    Box(
        modifier = Modifier.clip(MaterialTheme.shapes.medium)
    ) {
        Image(
            painter = painterResource(wranglerImageId),
            contentDescription = stringResource(id = wranglerDayId),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
private fun WranglerItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                tint = MaterialTheme.colors.primary,
                contentDescription = null,
            )
        }
    }
}