package com.ndejje.obituaryapp.ui

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ndejje.obituaryapp.model.Announcement
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class EditorUiState(
    val deceasedName: String = "",
    val dateOfBirth: String = "",
    val dateOfDeath: String = "",
    val burialDate: String = "",
    val village: String = "",
    val latitude: Double? = null,
    val longitude: Double? = null,
    val imageUri: Uri? = null,
    val selectedTemplateId: Int = 0, // 0=Classic White, 1=Buganda Traditional
    val isValid: Boolean = false
)

class AnnouncementViewModel(private val repository: AnnouncementRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(EditorUiState())
    val uiState: StateFlow<EditorUiState> = _uiState.asStateFlow()

    private val _announcements = MutableStateFlow<List<Announcement>>(emptyList())
    val announcements: StateFlow<List<Announcement>> = _announcements.asStateFlow()

    init {
        loadAnnouncements()
    }

    fun updateName(name: String) {
        _uiState.value = _uiState.value.copy(deceasedName = name)
        validate()
    }

    fun updateDob(dob: String) {
        _uiState.value = _uiState.value.copy(dateOfBirth = dob)
        validate()
    }

    fun updateDod(dod: String) {
        _uiState.value = _uiState.value.copy(dateOfDeath = dod)
        validate()
    }

    fun updateBurialDate(date: String) {
        _uiState.value = _uiState.value.copy(burialDate = date)
        validate()
    }

    fun updateVillage(village: String) {
        _uiState.value = _uiState.value.copy(village = village)
        validate()
    }

    fun updateLocation(lat: Double, lon: Double) {
        _uiState.value = _uiState.value.copy(latitude = lat, longitude = lon)
        validate()
    }

    fun updateImage(uri: Uri) {
        _uiState.value = _uiState.value.copy(imageUri = uri)
        validate()
    }

    fun selectTemplate(templateId: Int) {
        _uiState.value = _uiState.value.copy(selectedTemplateId = templateId)
        validate()
    }

    private fun validate() {
        val state = _uiState.value
        val isValid = state.deceasedName.isNotBlank() &&
                state.dateOfBirth.isNotBlank() &&
                state.dateOfDeath.isNotBlank() &&
                state.burialDate.isNotBlank() &&
                state.village.isNotBlank()
        _uiState.value = state.copy(isValid = isValid)
    }

    fun resetForm() {
        _uiState.value = EditorUiState()
    }

    fun saveCurrentAnnouncement() {
        val state = _uiState.value
        if (!state.isValid) return

        val announcement = Announcement(
            deceasedName = state.deceasedName,
            dateOfBirth = state.dateOfBirth,
            dateOfDeath = state.dateOfDeath,
            burialDate = state.burialDate,
            village = state.village,
            latitude = state.latitude,
            longitude = state.longitude,
            imagePath = state.imageUri?.toString(),
            templateId = state.selectedTemplateId
        )
        viewModelScope.launch {
            repository.saveAnnouncement(announcement)
            loadAnnouncements()
        }
    }

    private fun loadAnnouncements() {
        viewModelScope.launch {
            repository.getAllAnnouncements().collect { list ->
                _announcements.value = list
            }
        }
    }
}
