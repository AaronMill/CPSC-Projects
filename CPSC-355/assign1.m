/*this program computes the expression:
y = 2x^3 - 19x^2 + 9x + 45 for x = -2,-1, ... 10 with macros and optimization
*/

define(a3, 2)				!a3		2
define(a2, 19)				!a2		19
define(a1, 9)				!a1		9
define(a0, 45)				!a0		45
define(min, %l4)			!min 	l4
define(x_r, %l6)			!'%l6	x_r'	
define(y_r, %l5)			!'%l5	y_r'

fmt:	.asciz	"Value one: %3d\nValue two: %3d\nMinimum: %3d\n"	!formating for printing
		.align	4
		.global main  
main:
	save %sp, -96, %sp

	mov  0, min						!initialize the min to 0
    mov  -2, x_r		            !initialize x to -2

test:
	cmp 	x_r,	10				!subtract 10 from x, setting condition codes and discarding result

	bg		done					!branch over the loop when x > 10	
	
loop:
	mov 	x_r, %o0
	call	.mul		       		!computes 2x^3
	mov 	x_r, %o1
	call	.mul
	mov	x_r, %o1 
	mov	%o0, y_r	
	call	.mul					!stores part of equation in y
	mov a3,	%o1
	mov	%o0, y_r					!stores part of equation in y again

	mov     x_r,	%o1
	call	.mul					!computes 19x^2			
	mov		x_r, 	%o0
	call	.mul
	mov	 a2,	%o1
	sub y_r, %o0,	y_r	        	!2x^3 - 19x^2

	mov	a1,	%o0
	call	.mul					!computes 9x
	mov	x_r,	%o1
	add	y_r, %o0, y_r				!2x^3 - 19x^2 + 9x

	mov	a0,	%o0
	add	y_r, %o0, y_r				!2x^3 - 19x^2 + 9x + 45 	

	cmp y_r, min					!compare the y and the min
	bge print
	nop

	mov	y_r, min					!replace l4 with y_r if cond. met

print:
	set fmt, %o0				!set formatting options
	mov x_r, %o1				!store x in printing register
	mov y_r, %o2				!store y in printing register
	mov min, %o3				!store min. value in printing register
	call	printf 				! call print
	add	x_r, 1, x_r		        !x++
	ba next

next:
	cmp x_r,  10			!test
	ble	loop				!branch beginning of the loop						!delay slot

done:						
	mov	1,	%g1     		!trap dispatch  
	ta 	0                  	!trap to system
