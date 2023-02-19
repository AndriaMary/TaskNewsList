package com.assessment.tasknewslist.model
import java.io.Serializable


data class MainContent(
    val id: Int,
    val title: String?,
    val description: String?,
    val source: String?,
    val sourceId: String?,
    val version: String?,
    val publishedAt: Long?,
    val readablePublishedAt: String?,
    val updatedAt: Long?,
    val readableUpdatedAt: String?,
    val type: String?,
    val active: Boolean?,
    val draft: Boolean?,
    val embedTypes: String?,
    val images: Images,
    val language: String?
): Serializable


