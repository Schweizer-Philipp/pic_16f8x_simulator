package commandLine;

import java.util.stream.Stream;

/**
 * hso.ra.java.simulator.pic16f8x
 * commandLine
 * Mike Bruder, Philipp Schweizer
 * 7.11.2018
 */

public enum CommandCode {

    ADDWF(0x0700),
    ANDWF(0x0500),
    CLRF(0x0180),
    CLRW(0x0100),
    COMF(0x0900),
    DECF(0x0300),
    DECFSZ(0x0B00),
    INCF(0x0A00),
    INCFSZ(0x0F00),
    IORWF(0x0400),
    MOVF(0x0800),
    MOVWF(0x0080),
    NOP(0x0000),
    RLF(0x0D00),
    RRF(0x0C00),
    SUBWF(0x0200),
    SWAPF(0x0E00),
    XORWF(0x0600),
    BCF(0x1000),
    BSF(0x1400),
    BTFSC(0x1800),
    BTFSS(0x1C00),
    ADDLW(0x3E00),
    ANDLW(0x3900),
    CALL(0x2000),
    CLRWDT(0x0064),
    GOTO(0x2800),
    IORLW(0x3800),
    MOVLW(0x3000),
    RETFIE(0x0009),
    RETLW(0x3400),
    RETURN(0x0008),
    SLEEP(0x0063),
    SUBLW(0x3C00),
    XORLW(0x3A00),
    DEFAULT(0xFFFF);

    private int value;


    CommandCode(int value) {

        this.value = value;
    }

    public static CommandCode getCommandCodesByValue(int value) {

        return Stream.of(CommandCode.values()).filter(c -> c.value == value).findFirst().orElse(CommandCode.DEFAULT);
    }
}
