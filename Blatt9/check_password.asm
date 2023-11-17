Disassembly of section .text:

0000000000400630 <check_password>:
  400630:   cmp    rsi,0x1
  400634:   jle    4006af <check_password+0x7f>
  400636:   push   rbp
  400637:   push   rbx
  400638:   mov    rbx,rsi
  40063b:   xor    eax,eax
  40063d:   mov    rbp,rdi
  400640:   mov    edi,0x400734
  400645:   sub    rsp,0x18
  400649:   lea    rdx,[rsp+0xc]
  40064e:   lea    rsi,[rsp+0x8]
  400653:   call   400480 <scanf>               ; scanf()-Funktion aus C
  400658:   cmp    eax,0x2
  40065b:   mov    edx,0xffffffff
  400660:   jne    40068c <check_password+0x5c>
  400662:   lea    rax,[rbp+0x1]
  400666:   lea    rcx,[rbp+rbx*1+0x0]
  40066b:   nop                                 ; No-operation (Compileroptimierung)
  400670:   mov    edx,BYTE PTR [rax-0x1]
  400674:   add    BYTE PTR [rax],dl
  400676:   add    rax,0x1
  40067a:   cmp    rcx,rax
  40067d:   jne    400670 <check_password+0x40>
  40067f:   mov    eax,BYTE PTR [rbp+rbx*1-0x2]
  400684:   xor    edx,edx
  400686:   cmp    eax,DWORD PTR [rsp+0x8]
  40068a:   je     400698 <check_password+0x68>
  40068c:   add    rsp,0x18
  400690:   mov    eax,edx
  400692:   pop    rbx
  400693:   pop    rbp
  400694:   ret    
  400695:   nop                                  ; No-operation (Compileroptimierung)
  400698:   mov    eax,BYTE PTR [rbp+rbx*1-0x1]
  40069d:   xor    edx,edx
  40069f:   cmp    eax,DWORD PTR [rsp+0xc]
  4006a3:   sete   dl                            ; if ZF = 1 then DL := 1 else DL := 0
  4006a6:   add    rsp,0x18
  4006aa:   mov    eax,edx
  4006ac:   pop    rbx
  4006ad:   pop    rbp
  4006ae:   ret    
  4006af:   mov    edx,0xfffffffe
  4006b4:   mov    eax,edx
  4006b6:   ret    

00000000004004a0 <main>:
  4004a0:   sub    rsp,0x28
  ... ; Böser Verschlüsselungscode
  4004a4:   mov    esi,0x5
  4004a9:   mov    rdi,rsp
  4004ac:   mov    BYTE PTR [rsp],0x1
  4004b0:   mov    BYTE PTR [rsp+0x1],0x2
  4004b5:   mov    BYTE PTR [rsp+0x2],0x3
  4004ba:   mov    BYTE PTR [rsp+0x3],0x4
  4004bf:   mov    BYTE PTR [rsp+0x4],0x5
  4004c4:   call   400630 <check_password>
  ... ; Hoffentlich netter Entschlüsselungscode

Contents of section .rodata:
  400730:   01 00 02 00  25 64 2c 25  64 00 25 64  20 25 64 0a  ....%d,%d.%d %d.
  400740:   00  