## Dlaczego przy SeekBar nie można użyć lambdy, a przy CheckBox tak?

Interfejs SeekBar.OnSeekBarChangeListener posiada trzy metody, dlatego nie można go obsłużyć za pomocą lambdy. CheckBox.OnCheckedChangeListener posiada tylko jedną metodę, więc można użyć lambdy.