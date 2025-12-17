package com.example.responsive.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.responsive.model.User

class RegisterViewModel : ViewModel() {
    
    private val _user = MutableLiveData<User>(User())
    val user: LiveData<User> = _user
    
    private val _nombreCompletoError = MutableLiveData<String?>()
    val nombreCompletoError: LiveData<String?> = _nombreCompletoError
    
    private val _emailError = MutableLiveData<String?>()
    val emailError: LiveData<String?> = _emailError
    
    private val _telefonoError = MutableLiveData<String?>()
    val telefonoError: LiveData<String?> = _telefonoError
    
    private val _nombreUsuarioError = MutableLiveData<String?>()
    val nombreUsuarioError: LiveData<String?> = _nombreUsuarioError
    
    private val _passwordError = MutableLiveData<String?>()
    val passwordError: LiveData<String?> = _passwordError
    
    private val _confirmPasswordError = MutableLiveData<String?>()
    val confirmPasswordError: LiveData<String?> = _confirmPasswordError
    
    private val _terminosError = MutableLiveData<String?>()
    val terminosError: LiveData<String?> = _terminosError
    
    private val _isFormValid = MutableLiveData<Boolean>(false)
    val isFormValid: LiveData<Boolean> = _isFormValid
    
    fun updateNombreCompleto(nombre: String) {
        _user.value = _user.value?.copy(nombreCompleto = nombre)
        validateNombreCompleto(nombre)
    }
    
    fun updateFechaNacimiento(fecha: String) {
        _user.value = _user.value?.copy(fechaNacimiento = fecha)
    }
    
    fun updateEmail(email: String) {
        _user.value = _user.value?.copy(email = email)
        validateEmail(email)
    }
    
    fun updateTelefono(telefono: String) {
        _user.value = _user.value?.copy(telefono = telefono)
        validateTelefono(telefono)
    }
    
    fun updateNombreUsuario(nombreUsuario: String) {
        _user.value = _user.value?.copy(nombreUsuario = nombreUsuario)
        validateNombreUsuario(nombreUsuario)
    }
    
    fun updatePassword(password: String) {
        _user.value = _user.value?.copy(password = password)
        validatePassword(password)
        validateConfirmPassword(_user.value?.confirmPassword ?: "")
    }
    
    fun updateConfirmPassword(confirmPassword: String) {
        _user.value = _user.value?.copy(confirmPassword = confirmPassword)
        validateConfirmPassword(confirmPassword)
    }
    
    fun updateAceptaTerminos(acepta: Boolean) {
        _user.value = _user.value?.copy(aceptaTerminos = acepta)
        validateTerminos(acepta)
    }
    
    private fun validateNombreCompleto(nombre: String) {
        _nombreCompletoError.value = when {
            nombre.isBlank() -> "El nombre completo es obligatorio"
            nombre.length < 3 -> "El nombre debe tener al menos 3 caracteres"
            !nombre.all { it.isLetter() || it.isWhitespace() } -> "El nombre solo puede contener letras"
            else -> null
        }
        validateForm()
    }
    
    private fun validateEmail(email: String) {
        _emailError.value = when {
            email.isBlank() -> "El email es obligatorio"
            !email.contains("@") -> "El email debe contener @"
            !email.contains(".") -> "El email debe tener un dominio válido"
            else -> null
        }
        validateForm()
    }
    
    private fun validateTelefono(telefono: String) {
        _telefonoError.value = when {
            telefono.isBlank() -> "El teléfono es obligatorio"
            !telefono.all { it.isDigit() } -> "El teléfono solo puede contener números"
            telefono.length < 9 -> "El teléfono debe tener al menos 9 dígitos"
            else -> null
        }
        validateForm()
    }
    
    private fun validateNombreUsuario(nombreUsuario: String) {
        _nombreUsuarioError.value = when {
            nombreUsuario.isBlank() -> "El nombre de usuario es obligatorio"
            nombreUsuario.length < 3 -> "El nombre de usuario debe tener al menos 3 caracteres"
            else -> null
        }
        validateForm()
    }
    
    private fun validatePassword(password: String) {
        _passwordError.value = when {
            password.isBlank() -> "La contraseña es obligatoria"
            password.length < 6 -> "La contraseña debe tener al menos 6 caracteres"
            else -> null
        }
        validateForm()
    }
    
    private fun validateConfirmPassword(confirmPassword: String) {
        val password = _user.value?.password ?: ""
        _confirmPasswordError.value = when {
            confirmPassword.isBlank() -> "Debe confirmar la contraseña"
            confirmPassword != password -> "Las contraseñas no coinciden"
            else -> null
        }
        validateForm()
    }
    
    private fun validateTerminos(acepta: Boolean) {
        _terminosError.value = if (!acepta) "Debe aceptar los términos y condiciones" else null
        validateForm()
    }
    
    private fun validateForm() {
        val user = _user.value ?: return
        _isFormValid.value = 
            _nombreCompletoError.value == null &&
            _emailError.value == null &&
            _telefonoError.value == null &&
            _nombreUsuarioError.value == null &&
            _passwordError.value == null &&
            _confirmPasswordError.value == null &&
            _terminosError.value == null &&
            user.nombreCompleto.isNotBlank() &&
            user.email.isNotBlank() &&
            user.telefono.isNotBlank() &&
            user.nombreUsuario.isNotBlank() &&
            user.password.isNotBlank() &&
            user.confirmPassword.isNotBlank() &&
            user.aceptaTerminos
    }
    
    fun submitForm(): Boolean {
        validateForm()
        return _isFormValid.value == true
    }
}

