; GradesII.asm
;
; Author:               Soomin Lee
; Course:               CST8216 Processor Architecture
; Student Number:       040899389
; Date:                 17-Nov-2021
;
; Purpose:              To Tally up the number of As, Bs, Cs, Ds and Fs
;                       from a Grades Array as per 21F Flowchart for GradesII
;                       which uses a Nested-IF structure

LEN                    equ     End_Grades-Grades      ; Grades array length
                       org     $1000    ; origin
Grades
#include Grades.txt                     ; Grades.txt file
End_Grades


                org     $1020
Total_F:        ds      1               ; total of F in the file,$1000
Total_D:        ds      1               ; total of D in the file,$1001
Total_C:        ds      1               ; total of C in the file,$1002
Total_B:        ds      1               ; total of B in the file,$1003
Total_A:        ds      1               ; total of A in the file,$1004

; Expected Result
; $1000 $1005 $100a $100b
;  5      5     3     3
;
; $1020 $1021 $1022 $1023   $1024
;   F      D     C     B     A
; As shown in the simulator

                org     $2000
                lds     #$2000          ; stack
                ldx     #Grades         ; pointer x is pointing Grades array
                ldy     #$1020          ; pointer y is pointing the memory, result will be sotred
                ldab    #$00            ; b, set to counter for counting the number (starting from zero)
                
Read            ldaa    1,x+            ; load data pointer x then increment x
                cmpa    #$46            ; compare with character F
                beq     is_F            ; if eaqual F = is_F
                cmpa    #$44            ; compare with character D
                beq     is_D            ; if equal D = is_D
                cmpa    #$43            ; compare with character C
                beq     is_C            ; if equal C = is_C
                cmpa    #$42            ; compare with character B
                beq     is_B            ; if equal B = is_B
                cmpa    #$41            ; compare with character A
                beq     is_A            ; if equal A = is_A
                
is_F            inc     Total_F         ; increment total number of F
                bra     Check           ; go to check block
is_D            inc     Total_D         ; increment total number of D
                bra     Check           ; go to check block
is_C            inc     Total_C         ; increment total number of C
                bra     Check           ; go to check block
is_B            inc     Total_B         ; increment total number of B
                bra     Check           ; go to check block
is_A            inc     Total_A         ; increment total number of A
                bra     Check           ; go to check block
                
Check           incb                    ; increment register b (counter)
                cmpb    #LEN                      ; compare if b is the end of array
                bne     Read            ; go back if not euqal to end of array
                
                ldaa    Total_F         ; load total number of F
                staa    1,y+            ; store and increment pointer y
                ldaa    Total_D         ; load total number of D
                staa    1,y+            ; store and increment pointer y
                ldaa    Total_C         ; load total number of C
                staa    1,y+            ; store and increment pointer y
                ldaa    Total_B         ; load total number of B
                staa    1,y+            ; store and increment pointer y
                ldaa    Total_A         ; load total number of A
                staa    1,y+            ; store and increment pointer y
                
                clr    Total_A         ; clear memory
                clr    Total_B         ; clear memory
                clr    Total_C         ; clear memory
                clr    Total_D         ; clear memory
                clr    Total_F         ; clear memory

                swi                     ; quit
                end