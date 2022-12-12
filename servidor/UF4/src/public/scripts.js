document.addEventListener("DOMContentLoaded", () => {
  document.querySelector('#checkbox-gratis').addEventListener('change', disableSelect, false);
  function disableSelect() {
    const precioChecked = document.querySelector('#checkbox-gratis');
    const precio = document.querySelector('#select-precio');

    if(precioChecked.checked) {
      precio.disabled = true;
    } else {
      precio.disabled = false;
    }
  }
});
