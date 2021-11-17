; FX.asm
;
; Author:               Soomin Lee
; Course:               CST8216 Processor Architecture
; Student Number:       040899389
; Date:                 17-Nov-2021
;
; Purpose:      To illustrate how to solve an equation such as:
;               f(x) = 5x + 3 for x = 0 to 9, using 8-bit Multiplication
;               The calculated x in f(x) values will be placed into the X_Values array
;               The calculated f(x) values will be placed into the Results array
;
ARRAY_LEN       equ     10              ; Number of values to calculate (10): x = 0 to 9
                                        ; Need two arrays of length ARRAY_LEN
                                        ; - one holds x = 0 to 9
                                        ; - one holds f(x) results
                                        

        org             $1020              ; org as per assignment instructions
X_Values
        ds              ARRAY_LEN    	   ; Value of x used in calculation stored here
End_X_Values

        org             $1030              ; org as per assignment instructions
Results
        ds              ARRAY_LEN          ; Result of f(x) calculation stored here
End_Results

; Expected Results

;  $1000-$1009      $100a         $1020         $102a        $1030      $103a
;    LookUp       End_LookUp     X_Values    End_X_Values   Results  End_Results


        org     $2000                   ; program code
        lds     #$1000                  ; stack
        ldx     #X_Values               ; pointer x is pointing X_Values array
        ldy     #Results                ; pointer x is pointing LookUp array
        ldaa    #$00                    ; load a from zero (storing index of array)
        
Loop    ldab    A,X                     ; load register b at index of LookUp array
        clr     A,X                     ; clear index of x
        stab    ARRAY_LEN,Y             ; store b and increment y+offset
        staa    1,Y+                    ; store a and increment y
        inca                            ; increment a
        cmpa    #ARRAY_LEN              ; compare if reach to the end of the array
        bne     Loop                    ; go back to loop if not the end

        swi
        end