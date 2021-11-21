; FX.asm
;
; Author:               Soomin Lee, sorry I don't know how to set array with 8-bit multiplication, can I have sample code later?
; Course:               CST8216 Processor Architecture
; Student Number:       040899389
; Date:                 17-Nov-2021
;
; Purpose:      To illustrate how to solve an equation such as:
;               f(x) = 5x + 3 for x = 0 to 9, using 8-bit Multiplication
;               The calculated x in f(x) values will be placed into the X_Values array
;               The calculated f(x) values will be placed into the Results array

ARRAY_LEN       equ     10              		; Number of values to calculate (10): x = 0 to 9
                org	$1000           		; Need two arrays of length ARRAY_LEN
Array
		; ?? I don't understand			; - one holds x = 0 to 9
 		db	3,8,13,18,23,28,33,38,43,48 	; - one holds f(x) results
End_Array

        	org             $1020              		; org as per assignment instructions
X_Values
        	ds              End_Array-Array 		; Value of x used in calculation stored here
End_X_Values

        	org             $1030              		; org as per assignment instructions
Results
        	ds              End_Array-Array                	; Result of f(x) calculation stored here
End_Results

; Expected Results

;     $1020         $102a        $1030      $103a
;   X_Values    End_X_Values   Results  End_Results


        org     $2000                   ; program code
        lds     #$2000                  ; stack
        ldx     #X_Values               ; pointer x is pointing X_Values array
        ldy     #Results                ; pointer y is pointing Results array
        ldaa    #$00                    ; load a from zero (storing index of array)
        
Loop    ldab    A,X                     ; load register b at index
        clr     A,X                     ; clear index of x
        stab    ARRAY_LEN,Y             ; store b and increment y
        staa    1,Y+                    ; store a and increment y
        inca                            ; increment a
        cmpa    #ARRAY_LEN              ; compare if reach to the end of the array
        bne     Loop                    ; go back to loop if not the end

        swi
        end