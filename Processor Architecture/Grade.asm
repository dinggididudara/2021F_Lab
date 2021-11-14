; Assignment 2B
; Grade.asm
;
; Author:                Soomin
; Student Number:        040899389
; Date :                 06-Nov-2021
;
; Purpose:               Grade the marks in txt file

LEN     equ     End_Marks

        org     $1000           ; starts at address 1000
Marks
#include Marks.txt
End_Marks
                                ; Expected Result will be:
                                ; each array will be store at
				; $1000 $1004 $1008 $100C

        org     $1030
A:      ds      1               ; Grade A will store in memory location F
B:      ds      1               ; Grade B will store in memory location F
C:      ds      1               ; Grade C will store in memory location F
D:      ds      1               ; Grade D will store in memory location F
F:      ds      1               ; Grade F will store in memory location F


; program code starts
        org     $2000           ; program starts
        lds     #$2000          ; initialize
        ldx     #Marks         	; pointer x to beginning of Grades array
        ldy     #$103A          ; pointer y to memory that sotres result
        ldab    #$00            ; load register b with $00

Read    ldaa    1,x+            ;load register with pointer, increment x
        ldaa    Marks           ; get temporary value
        cmpa    90              ; greater than 90?
        bhi     aa              ; if higher or same

        cmpa    80              ; greater than 80?
        bhi     bb              ; if higher than 80?

        cmpa    70              ; greater than 70?
        bhi     cc              ; if higher or same

        cmpa    60              ; greater than 60?
        bhi     dd              ; if higher or same
        cmpa    60              ; less than 60?
        bls     ff              ;

aa      inc     A               ; increment at location A
        bra     Check           ; go to check block
        
bb      inc     B               ; increment at location B
        bra     Check           ; go to check block

cc      inc     C               ; increment at location C
        bra     Check           ; go to check block
        
dd      inc     D               ; increment at location D
        bra     Check           ; go to check block

ff      inc     F               ; increment at location F
        bra     Check           ; go to check block
        
Check   incb                    ; increment register b
        cmpb    LEN            ; compare register b to len (length)
        bne     Read            ; go back to read block if not equal
        
        ldaa    A               ; load register A
        staa    1,y+            ; store register in pointer y
        ldaa    B               ; load register B
        staa    1,y+            ; store register in pointer y
        ldaa    C               ; load register C
        staa    1,y+            ; store register in pointer y
        ldaa    D               ; load register D
        staa    1,y+            ; store register in pointer y
        ldaa    F               ; load register F
        staa    1,y+            ; store register in pointer y
        
        clr     A               ; clear memory in A
        clr     B               ; clear memory in B
        clr     C               ; clear memory in C
        clr     D               ; clear memory in D
        clr     F               ; clear memory in F
        
        swi                     ; program quit
        end
        