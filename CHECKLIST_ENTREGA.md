# ✅ Checklist de Entrega - Proyecto Responsive

## 📋 Verificación Pre-Entrega

Marca cada ítem antes de entregar el proyecto:

---

## 1️⃣ CÓDIGO FUNCIONAL

### Compilación
- [ ] El proyecto compila sin errores en Android Studio
- [ ] No hay warnings críticos
- [ ] Todas las dependencias están correctamente configuradas

### Ejecución
- [ ] La app arranca correctamente en el emulador
- [ ] No hay crashes al navegar entre pantallas
- [ ] El formulario se puede rellenar completamente

### Funcionalidad
- [ ] El banner se muestra correctamente
- [ ] Los 8 campos del formulario funcionan
- [ ] Las validaciones funcionan en tiempo real
- [ ] El botón se habilita/deshabilita correctamente
- [ ] La navegación a ConfirmScreen funciona
- [ ] El botón "Volver al inicio" regresa a RegisterScreen

---

## 2️⃣ VALIDACIONES

Prueba cada validación ingresando datos incorrectos:

### Nombre Completo
- [ ] Muestra error si está vacío
- [ ] Muestra error si tiene menos de 3 caracteres
- [ ] Muestra error si contiene números
- [ ] Acepta nombres con espacios (ej: "Juan Pérez")

### Fecha de Nacimiento
- [ ] Muestra error si está vacía
- [ ] Muestra error con formato incorrecto (ej: "25-12-2000")
- [ ] Muestra error si día > 31
- [ ] Muestra error si mes > 12
- [ ] Muestra error si año < 1900 o > 2024
- [ ] Acepta fecha correcta (ej: "25/12/2000")

### Email
- [ ] Muestra error si está vacío
- [ ] Muestra error si no tiene @
- [ ] Muestra error si no tiene dominio (ej: "juan@")
- [ ] Acepta email válido (ej: "juan@gmail.com")

### Teléfono
- [ ] Muestra error si está vacío
- [ ] Muestra error si contiene letras
- [ ] Muestra error si tiene menos de 9 dígitos
- [ ] Acepta teléfono de 9+ dígitos

### Nombre de Usuario
- [ ] Muestra error si está vacío
- [ ] Muestra error si tiene menos de 3 caracteres
- [ ] Acepta usuario válido

### Contraseña
- [ ] Muestra error si está vacía
- [ ] Muestra error si tiene menos de 6 caracteres
- [ ] Acepta contraseña válida

### Confirmar Contraseña
- [ ] Muestra error si está vacía
- [ ] Muestra error si no coincide con la contraseña
- [ ] Acepta si coincide exactamente

### Términos y Condiciones
- [ ] Muestra error si no está marcado
- [ ] Permite continuar si está marcado

---

## 3️⃣ RESPONSIVE Y ADAPTATIVO

### Prueba en Móvil (Compact)
- [ ] Ejecuta en Pixel 5 (o similar) en VERTICAL
- [ ] El formulario se ve completo con scroll
- [ ] Los textos son cortos ("Usuario", "Confirmar")
- [ ] El padding es reducido (12dp)
- [ ] Banner oculta el lema SI la pantalla es MUY pequeña

### Prueba en Tablet Medium
- [ ] Ejecuta en Pixel Tablet en VERTICAL
- [ ] O rota el móvil a HORIZONTAL
- [ ] El formulario está centrado con márgenes
- [ ] El ancho máximo es ~500dp
- [ ] Los textos son completos
- [ ] El lema del banner se muestra

### Prueba en Tablet Expanded
- [ ] Ejecuta en tablet en HORIZONTAL
- [ ] O usa pantalla resizable muy grande
- [ ] El formulario está centrado con amplios márgenes
- [ ] El ancho máximo es ~600dp
- [ ] Los elementos son más espaciados
- [ ] Todo se ve proporcionado

### Rotación del Dispositivo
- [ ] En móvil vertical → rotar a horizontal → el scroll funciona
- [ ] Los datos del formulario NO se pierden al rotar
- [ ] El diseño se adapta automáticamente

---

## 4️⃣ DOCUMENTACIÓN

### README.md
- [ ] Existe el archivo README.md
- [ ] Tiene descripción del proyecto
- [ ] Lista todos los requerimientos cumplidos
- [ ] Explica técnicas responsive
- [ ] Explica técnicas adaptativas
- [ ] Tiene tabla de composables utilizados
- [ ] Tiene referencias a la teoría
- [ ] Tiene sección de autores
- [ ] ⚠️ Tiene las 5 capturas en carpeta screenshots/

### Otros Documentos
- [ ] MEJORAS_IMPLEMENTADAS.md existe
- [ ] INSTRUCCIONES_CAPTURAS.md existe
- [ ] RESUMEN_PROYECTO.md existe

---

## 5️⃣ CAPTURAS DE PANTALLA ⚠️ IMPORTANTE

### Carpeta screenshots/
- [ ] Existe la carpeta `screenshots/`
- [ ] Contiene `register_compact.png`
- [ ] Contiene `register_medium.png`
- [ ] Contiene `register_expanded.png`
- [ ] Contiene `validaciones.png`
- [ ] Contiene `confirm_screen.png`
- [ ] Las imágenes son PNG (no JPG)
- [ ] Los nombres son EXACTAMENTE como arriba
- [ ] Las imágenes se ven bien (no borrosas)
- [ ] Cada captura muestra lo que debe mostrar

### Contenido de las Capturas
- [ ] **register_compact.png**: Móvil vertical, se ve el formulario
- [ ] **register_medium.png**: Tablet vertical o móvil horizontal, centrado
- [ ] **register_expanded.png**: Tablet horizontal, muy centrado con márgenes
- [ ] **validaciones.png**: Se ven ERRORES en rojo bajo los campos
- [ ] **confirm_screen.png**: Pantalla de éxito con check verde y nombre

---

## 6️⃣ ESTRUCTURA DE ARCHIVOS

### Arquitectura MVVM
```
- [ ] app/src/main/java/com/example/responsive/
  - [ ] MainActivity.kt
  - [ ] model/User.kt
  - [ ] viewmodel/RegisterViewModel.kt
  - [ ] ui/components/Banner.kt
  - [ ] ui/screens/RegisterScreen.kt
  - [ ] ui/screens/ConfirmScreen.kt
  - [ ] navigation/NavGraph.kt
```

### Archivos Raíz
- [ ] README.md
- [ ] MEJORAS_IMPLEMENTADAS.md
- [ ] INSTRUCCIONES_CAPTURAS.md
- [ ] RESUMEN_PROYECTO.md
- [ ] screenshots/README.md
- [ ] screenshots/*.png (5 archivos)

---

## 7️⃣ GIT Y GITHUB

### Repositorio
- [ ] El repositorio está en GitHub
- [ ] El repositorio es **PÚBLICO** (o tienes permisos compartidos)
- [ ] El nombre del repo es claro
- [ ] Todos los archivos están subidos

### Commits
- [ ] Has hecho commit de todos los cambios
- [ ] El último commit incluye las capturas
- [ ] Has hecho push al repositorio remoto
- [ ] Verificaste en GitHub web que todo se ve bien

---

## 8️⃣ REVISIÓN FINAL

### Teoría Aplicada
- [ ] Cada técnica usada está en la teoría del curso
- [ ] No has usado librerías externas no permitidas
- [ ] El código sigue los ejemplos de la teoría

### Calidad del Código
- [ ] No hay código comentado innecesario
- [ ] Los nombres de variables son descriptivos
- [ ] El código está bien indentado
- [ ] No hay warnings importantes

### Enunciado
- [ ] Re-leer el enunciado completo
- [ ] Verificar que cumples TODOS los puntos
- [ ] Verificar que no falta nada

---

## 9️⃣ AUTOEVALUACIÓN

Según la rúbrica del enunciado:

| Criterio | Puntos | ¿Cumplido? |
|----------|--------|------------|
| Técnicas Adaptative | 2.00 | [ ] |
| Técnicas Responsive | 2.00 | [ ] |
| Composables MVVM + LiveData + NavHost | 2.00 | [ ] |
| Validaciones | 2.00 | [ ] |
| Layout + Logo + Lema | 1.00 | [ ] |
| Smart Coding + README con capturas | 1.00 | [ ] |

**Si todos están marcados = 10/10 puntos** ✅

---

## 🔟 ENTREGA FINAL

### Antes de Entregar
- [ ] Todas las casillas de arriba están marcadas ✅
- [ ] Has probado la app en al menos 2 tamaños de pantalla
- [ ] Has leído el README.md completo
- [ ] El enlace de GitHub funciona

### Formato de Entrega
- [ ] Tienes el enlace del repositorio GitHub listo
- [ ] El formato es: `https://github.com/usuario/pr05-sign-in-responsive...`
- [ ] Has verificado que el repo es accesible
- [ ] Has verificado que las imágenes se ven en GitHub

---

## ✅ ENTREGA

**Si TODAS las casillas están marcadas**, tu proyecto está listo para:

```
✅ ENTREGAR CON CONFIANZA
✅ ESPERAR UN 10/10
✅ IMPRESIONAR AL PROFESOR
```

---

## ⚠️ Problemas Comunes

### Si algo no funciona:

1. **No compila**: 
   - File > Invalidate Caches > Invalidate and Restart
   - Build > Clean Project > Build > Rebuild Project

2. **Falta una captura**:
   - Lee INSTRUCCIONES_CAPTURAS.md
   - Tómala de nuevo
   - Verifica el nombre exacto

3. **El README no muestra las imágenes**:
   - En GitHub, las rutas son: `screenshots/nombre.png`
   - Verificar que las imágenes están en la carpeta correcta
   - Verificar que están en el commit

4. **La app crashea**:
   - Revisa el Logcat en Android Studio
   - Busca la línea que causa el error
   - Compara con el código original

---

## 🎓 ¡ÉXITO!

Si has llegado aquí y todo está marcado, ¡ENHORABUENA!

Tu proyecto está **completo, funcional y bien documentado**.

**Puntuación esperada**: 10/10 ⭐⭐⭐⭐⭐

---

*Checklist creado para: Mateo Acha y Pablo Arenas*
*Proyecto: FitGym - Sign In Responsive & Adaptative*
*Fecha: Diciembre 2024*
