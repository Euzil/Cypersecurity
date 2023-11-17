
protectiontest:     file format elf64-x86-64


Disassembly of section .init:

0000000000001000 <_init>:
    1000:	f3 0f 1e fa          	endbr64 
    1004:	48 83 ec 08          	sub    rsp,0x8
    1008:	48 8b 05 d9 2f 00 00 	mov    rax,QWORD PTR [rip+0x2fd9]        # 3fe8 <__gmon_start__>
    100f:	48 85 c0             	test   rax,rax
    1012:	74 02                	je     1016 <_init+0x16>
    1014:	ff d0                	call   rax
    1016:	48 83 c4 08          	add    rsp,0x8
    101a:	c3                   	ret    

Disassembly of section .plt:

0000000000001020 <.plt>:
    1020:	ff 35 8a 2f 00 00    	push   QWORD PTR [rip+0x2f8a]        # 3fb0 <_GLOBAL_OFFSET_TABLE_+0x8>
    1026:	f2 ff 25 8b 2f 00 00 	bnd jmp QWORD PTR [rip+0x2f8b]        # 3fb8 <_GLOBAL_OFFSET_TABLE_+0x10>
    102d:	0f 1f 00             	nop    DWORD PTR [rax]
    1030:	f3 0f 1e fa          	endbr64 
    1034:	68 00 00 00 00       	push   0x0
    1039:	f2 e9 e1 ff ff ff    	bnd jmp 1020 <.plt>
    103f:	90                   	nop
    1040:	f3 0f 1e fa          	endbr64 
    1044:	68 01 00 00 00       	push   0x1
    1049:	f2 e9 d1 ff ff ff    	bnd jmp 1020 <.plt>
    104f:	90                   	nop
    1050:	f3 0f 1e fa          	endbr64 
    1054:	68 02 00 00 00       	push   0x2
    1059:	f2 e9 c1 ff ff ff    	bnd jmp 1020 <.plt>
    105f:	90                   	nop

Disassembly of section .plt.got:

0000000000001060 <__cxa_finalize@plt>:
    1060:	f3 0f 1e fa          	endbr64 
    1064:	f2 ff 25 8d 2f 00 00 	bnd jmp QWORD PTR [rip+0x2f8d]        # 3ff8 <__cxa_finalize@GLIBC_2.2.5>
    106b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

Disassembly of section .plt.sec:

0000000000001070 <__stack_chk_fail@plt>:
    1070:	f3 0f 1e fa          	endbr64 
    1074:	f2 ff 25 45 2f 00 00 	bnd jmp QWORD PTR [rip+0x2f45]        # 3fc0 <__stack_chk_fail@GLIBC_2.4>
    107b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001080 <fgets@plt>:
    1080:	f3 0f 1e fa          	endbr64 
    1084:	f2 ff 25 3d 2f 00 00 	bnd jmp QWORD PTR [rip+0x2f3d]        # 3fc8 <fgets@GLIBC_2.2.5>
    108b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001090 <__printf_chk@plt>:
    1090:	f3 0f 1e fa          	endbr64 
    1094:	f2 ff 25 35 2f 00 00 	bnd jmp QWORD PTR [rip+0x2f35]        # 3fd0 <__printf_chk@GLIBC_2.3.4>
    109b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

Disassembly of section .text:

00000000000010a0 <main>:
    10a0:	f3 0f 1e fa          	endbr64 
    10a4:	50                   	push   rax
    10a5:	31 c0                	xor    eax,eax
    10a7:	e8 ed 00 00 00       	call   1199 <toUpperCase>
    10ac:	31 c0                	xor    eax,eax
    10ae:	5a                   	pop    rdx
    10af:	c3                   	ret    

00000000000010b0 <_start>:
    10b0:	f3 0f 1e fa          	endbr64 
    10b4:	31 ed                	xor    ebp,ebp
    10b6:	49 89 d1             	mov    r9,rdx
    10b9:	5e                   	pop    rsi
    10ba:	48 89 e2             	mov    rdx,rsp
    10bd:	48 83 e4 f0          	and    rsp,0xfffffffffffffff0
    10c1:	50                   	push   rax
    10c2:	54                   	push   rsp
    10c3:	4c 8d 05 e6 01 00 00 	lea    r8,[rip+0x1e6]        # 12b0 <__libc_csu_fini>
    10ca:	48 8d 0d 6f 01 00 00 	lea    rcx,[rip+0x16f]        # 1240 <__libc_csu_init>
    10d1:	48 8d 3d c8 ff ff ff 	lea    rdi,[rip+0xffffffffffffffc8]        # 10a0 <main>
    10d8:	ff 15 02 2f 00 00    	call   QWORD PTR [rip+0x2f02]        # 3fe0 <__libc_start_main@GLIBC_2.2.5>
    10de:	f4                   	hlt    
    10df:	90                   	nop

00000000000010e0 <deregister_tm_clones>:
    10e0:	48 8d 3d 29 2f 00 00 	lea    rdi,[rip+0x2f29]        # 4010 <stdin@@GLIBC_2.2.5>
    10e7:	48 8d 05 22 2f 00 00 	lea    rax,[rip+0x2f22]        # 4010 <stdin@@GLIBC_2.2.5>
    10ee:	48 39 f8             	cmp    rax,rdi
    10f1:	74 15                	je     1108 <deregister_tm_clones+0x28>
    10f3:	48 8b 05 de 2e 00 00 	mov    rax,QWORD PTR [rip+0x2ede]        # 3fd8 <_ITM_deregisterTMCloneTable>
    10fa:	48 85 c0             	test   rax,rax
    10fd:	74 09                	je     1108 <deregister_tm_clones+0x28>
    10ff:	ff e0                	jmp    rax
    1101:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]
    1108:	c3                   	ret    
    1109:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]

0000000000001110 <register_tm_clones>:
    1110:	48 8d 3d f9 2e 00 00 	lea    rdi,[rip+0x2ef9]        # 4010 <stdin@@GLIBC_2.2.5>
    1117:	48 8d 35 f2 2e 00 00 	lea    rsi,[rip+0x2ef2]        # 4010 <stdin@@GLIBC_2.2.5>
    111e:	48 29 fe             	sub    rsi,rdi
    1121:	48 89 f0             	mov    rax,rsi
    1124:	48 c1 ee 3f          	shr    rsi,0x3f
    1128:	48 c1 f8 03          	sar    rax,0x3
    112c:	48 01 c6             	add    rsi,rax
    112f:	48 d1 fe             	sar    rsi,1
    1132:	74 14                	je     1148 <register_tm_clones+0x38>
    1134:	48 8b 05 b5 2e 00 00 	mov    rax,QWORD PTR [rip+0x2eb5]        # 3ff0 <_ITM_registerTMCloneTable>
    113b:	48 85 c0             	test   rax,rax
    113e:	74 08                	je     1148 <register_tm_clones+0x38>
    1140:	ff e0                	jmp    rax
    1142:	66 0f 1f 44 00 00    	nop    WORD PTR [rax+rax*1+0x0]
    1148:	c3                   	ret    
    1149:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]

0000000000001150 <__do_global_dtors_aux>:
    1150:	f3 0f 1e fa          	endbr64 
    1154:	80 3d bd 2e 00 00 00 	cmp    BYTE PTR [rip+0x2ebd],0x0        # 4018 <completed.8060>
    115b:	75 2b                	jne    1188 <__do_global_dtors_aux+0x38>
    115d:	55                   	push   rbp
    115e:	48 83 3d 92 2e 00 00 	cmp    QWORD PTR [rip+0x2e92],0x0        # 3ff8 <__cxa_finalize@GLIBC_2.2.5>
    1165:	00 
    1166:	48 89 e5             	mov    rbp,rsp
    1169:	74 0c                	je     1177 <__do_global_dtors_aux+0x27>
    116b:	48 8b 3d 96 2e 00 00 	mov    rdi,QWORD PTR [rip+0x2e96]        # 4008 <__dso_handle>
    1172:	e8 e9 fe ff ff       	call   1060 <__cxa_finalize@plt>
    1177:	e8 64 ff ff ff       	call   10e0 <deregister_tm_clones>
    117c:	c6 05 95 2e 00 00 01 	mov    BYTE PTR [rip+0x2e95],0x1        # 4018 <completed.8060>
    1183:	5d                   	pop    rbp
    1184:	c3                   	ret    
    1185:	0f 1f 00             	nop    DWORD PTR [rax]
    1188:	c3                   	ret    
    1189:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]

0000000000001190 <frame_dummy>:
    1190:	f3 0f 1e fa          	endbr64 
    1194:	e9 77 ff ff ff       	jmp    1110 <register_tm_clones>

0000000000001199 <toUpperCase>:
    1199:	f3 0f 1e fa          	endbr64 
    119d:	41 54                	push   r12
    119f:	48 8d 35 5e 0e 00 00 	lea    rsi,[rip+0xe5e]        # 2004 <_IO_stdin_used+0x4>
    11a6:	bf 01 00 00 00       	mov    edi,0x1
    11ab:	48 83 ec 20          	sub    rsp,0x20
    11af:	64 48 8b 04 25 28 00 	mov    rax,QWORD PTR fs:0x28
    11b6:	00 00 
    11b8:	48 89 44 24 18       	mov    QWORD PTR [rsp+0x18],rax
    11bd:	31 c0                	xor    eax,eax
    11bf:	4c 8d 64 24 0e       	lea    r12,[rsp+0xe]
    11c4:	e8 c7 fe ff ff       	call   1090 <__printf_chk@plt>
    11c9:	48 8b 15 40 2e 00 00 	mov    rdx,QWORD PTR [rip+0x2e40]        # 4010 <stdin@@GLIBC_2.2.5>
    11d0:	be 0a 00 00 00       	mov    esi,0xa
    11d5:	4c 89 e7             	mov    rdi,r12
    11d8:	e8 a3 fe ff ff       	call   1080 <fgets@plt>
    11dd:	48 85 c0             	test   rax,rax
    11e0:	74 36                	je     1218 <toUpperCase+0x7f>
    11e2:	4c 89 e0             	mov    rax,r12
    11e5:	48 8d 4c 24 17       	lea    rcx,[rsp+0x17]
    11ea:	8a 10                	mov    dl,BYTE PTR [rax]
    11ec:	8d 72 9f             	lea    esi,[rdx-0x61]
    11ef:	40 80 fe 19          	cmp    sil,0x19
    11f3:	77 05                	ja     11fa <toUpperCase+0x61>
    11f5:	83 ea 20             	sub    edx,0x20
    11f8:	88 10                	mov    BYTE PTR [rax],dl
    11fa:	48 ff c0             	inc    rax
    11fd:	48 39 c8             	cmp    rax,rcx
    1200:	75 e8                	jne    11ea <toUpperCase+0x51>
    1202:	4c 89 e2             	mov    rdx,r12
    1205:	48 8d 35 32 0e 00 00 	lea    rsi,[rip+0xe32]        # 203e <_IO_stdin_used+0x3e>
    120c:	bf 01 00 00 00       	mov    edi,0x1
    1211:	31 c0                	xor    eax,eax
    1213:	e8 78 fe ff ff       	call   1090 <__printf_chk@plt>
    1218:	48 8b 4c 24 18       	mov    rcx,QWORD PTR [rsp+0x18]
    121d:	64 48 33 0c 25 28 00 	xor    rcx,QWORD PTR fs:0x28
    1224:	00 00 
    1226:	74 05                	je     122d <toUpperCase+0x94>
    1228:	e8 43 fe ff ff       	call   1070 <__stack_chk_fail@plt>
    122d:	48 83 c4 20          	add    rsp,0x20
    1231:	41 5c                	pop    r12
    1233:	c3                   	ret    
    1234:	66 2e 0f 1f 84 00 00 	nop    WORD PTR cs:[rax+rax*1+0x0]
    123b:	00 00 00 
    123e:	66 90                	xchg   ax,ax

0000000000001240 <__libc_csu_init>:
    1240:	f3 0f 1e fa          	endbr64 
    1244:	41 57                	push   r15
    1246:	4c 8d 3d 5b 2b 00 00 	lea    r15,[rip+0x2b5b]        # 3da8 <__frame_dummy_init_array_entry>
    124d:	41 56                	push   r14
    124f:	49 89 d6             	mov    r14,rdx
    1252:	41 55                	push   r13
    1254:	49 89 f5             	mov    r13,rsi
    1257:	41 54                	push   r12
    1259:	41 89 fc             	mov    r12d,edi
    125c:	55                   	push   rbp
    125d:	48 8d 2d 4c 2b 00 00 	lea    rbp,[rip+0x2b4c]        # 3db0 <__do_global_dtors_aux_fini_array_entry>
    1264:	53                   	push   rbx
    1265:	4c 29 fd             	sub    rbp,r15
    1268:	48 83 ec 08          	sub    rsp,0x8
    126c:	e8 8f fd ff ff       	call   1000 <_init>
    1271:	48 c1 fd 03          	sar    rbp,0x3
    1275:	74 1f                	je     1296 <__libc_csu_init+0x56>
    1277:	31 db                	xor    ebx,ebx
    1279:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]
    1280:	4c 89 f2             	mov    rdx,r14
    1283:	4c 89 ee             	mov    rsi,r13
    1286:	44 89 e7             	mov    edi,r12d
    1289:	41 ff 14 df          	call   QWORD PTR [r15+rbx*8]
    128d:	48 83 c3 01          	add    rbx,0x1
    1291:	48 39 dd             	cmp    rbp,rbx
    1294:	75 ea                	jne    1280 <__libc_csu_init+0x40>
    1296:	48 83 c4 08          	add    rsp,0x8
    129a:	5b                   	pop    rbx
    129b:	5d                   	pop    rbp
    129c:	41 5c                	pop    r12
    129e:	41 5d                	pop    r13
    12a0:	41 5e                	pop    r14
    12a2:	41 5f                	pop    r15
    12a4:	c3                   	ret    
    12a5:	66 66 2e 0f 1f 84 00 	data16 nop WORD PTR cs:[rax+rax*1+0x0]
    12ac:	00 00 00 00 

00000000000012b0 <__libc_csu_fini>:
    12b0:	f3 0f 1e fa          	endbr64 
    12b4:	c3                   	ret    

Disassembly of section .fini:

00000000000012b8 <_fini>:
    12b8:	f3 0f 1e fa          	endbr64 
    12bc:	48 83 ec 08          	sub    rsp,0x8
    12c0:	48 83 c4 08          	add    rsp,0x8
    12c4:	c3                   	ret    