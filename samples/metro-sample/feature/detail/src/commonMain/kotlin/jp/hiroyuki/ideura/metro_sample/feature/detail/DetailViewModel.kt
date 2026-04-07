package jp.hiroyuki.ideura.metro_sample.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.hiroyuki.ideura.metro_sample.core.model.UserDetail
import jp.hiroyuki.ideura.metro_sample.domain.repository.UserRepository
import dev.zacsweers.metro.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// Note: If login id is needed via AssistedInject, adjust accordingly.
// For simplicity, passing login via method here.

@Inject
class DetailViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _user = MutableStateFlow<UserDetail?>(null)
    val user: StateFlow<UserDetail?> = _user.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun loadUser(login: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _user.value = userRepository.getUserDetail(login)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
