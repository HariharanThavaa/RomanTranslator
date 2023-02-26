package com.jlr.roman.translator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Roman number translator Test class
 */
class RomanNumberTranslatorTest {

    /**
     * Instantiate translator
     */
    RomanNumberTranslator translator = new RomanNumberTranslator();

    @Test
    void translate() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            translator.translate(null);
        }).withMessage("Input cannot be null");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            translator.translate(0);
        }).withMessage("Input cannot be zero");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            translator.translate(-1);
        }).withMessage("Input cannot be negative");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            translator.translate(10000);
        }).withMessage("Input cannot be greater than 3000");

        assertThat(translator.translate(1)).isEqualTo("I");
        assertThat(translator.translate(2)).isEqualTo("II");
        assertThat(translator.translate(3)).isEqualTo("III");
        assertThat(translator.translate(4)).isEqualTo("IV");
        assertThat(translator.translate(5)).isEqualTo("V");
        assertThat(translator.translate(6)).isEqualTo("VI");
        assertThat(translator.translate(7)).isEqualTo("VII");
        assertThat(translator.translate(8)).isEqualTo("VIII");
        assertThat(translator.translate(9)).isEqualTo("IX");
        assertThat(translator.translate(10)).isEqualTo("X");
        assertThat(translator.translate(11)).isEqualTo("XI");
        assertThat(translator.translate(21)).isEqualTo("XXI");
        assertThat(translator.translate(55)).isEqualTo("LV");
        assertThat(translator.translate(111)).isEqualTo("CXI");
        assertThat(translator.translate(666)).isEqualTo("DCLXVI");
        assertThat(translator.translate(1994)).isEqualTo("MCMXCIV");
        assertThat(translator.translate(3000)).isEqualTo("MMM");
    }
}