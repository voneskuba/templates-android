package ${packageName}

import com.thefuntasty.mvvm.factory.BaseViewModelFactory
import javax.inject.Inject
import javax.inject.Provider

class ${className}ViewModelFactory @Inject constructor(
    override val viewModelProvider: Provider<${className}ViewModel>
) : BaseViewModelFactory<${className}ViewModel>()
