STACK 	equ 	$2000
        org     $1000
Numbers db      $01,$55,$22, $FE, $08
Result  ds.w    1
HST     db      15

        org     $2000
        lds     #Stack
        ldx     #Numbers
        ldaa    HST
        ldaa    3,x
        ldab    3,x+
        std     Result
