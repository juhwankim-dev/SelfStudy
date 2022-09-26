package com.example.presentation.views

import androidx.lifecycle.*
import com.example.domain.model.Temp
import com.example.domain.model.User
import com.example.domain.usecase.temp.GetTempListUseCase
import com.example.domain.usecase.user.ReadUserListUseCase
import com.example.domain.util.Result
import com.example.domain.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// viewModel에는 이 어노테이션을 붙여줘야 합니다. (hilt)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTempListUseCase: GetTempListUseCase,
    private val readUserListUseCase: ReadUserListUseCase
): ViewModel() {
    private val _tempResult = MutableLiveData<List<Temp>>()
    val tempResult: LiveData<List<Temp>> get() = _tempResult

    private val _problem = MutableLiveData<Result<Any>>()
    val problem: LiveData<Result<Any>> get() = _problem

    fun getTempList(page: Int) {
        viewModelScope.launch {
            val result = getTempListUseCase.invoke(page)
            if(result.status == Status.SUCCESS) {
                result.data.let { _tempResult.postValue(it) }
            } else {
                _problem.postValue(result)
            }
        }
    }

    fun readUserList(): LiveData<List<User>> {
        return readUserListUseCase().asLiveData()
    }
}