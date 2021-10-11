; Assignment2A.asm
;
; Author:                 Soomin
; Student Number:         040899389
; Date :                 06-Oct-2021
;
;Purpose:                add up the values: $25 +$37 - $1
;
        org     $1000           ; set current location to start of RAM
p:      db      $25             ; first add is at location p
q:      db      $37             ; second add is at location q
r:      ds      1               ; Sum will be stored at location r

        org     $2000           ; set current location to start in ROM
        ldaa    p               ; load value at p into accumulator a
        adda    q               ; add value at q into accumulator a
        deca                    ; decrement a
        staa    r               ; store accumulator a at location r
        end                     ; end of assembly language