PGDMP     !                    x           webapp    12.3    12.3     #           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            $           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            %           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            &           1262    24943    webapp    DATABASE     �   CREATE DATABASE webapp WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Greek_Greece.1253' LC_CTYPE = 'Greek_Greece.1253';
    DROP DATABASE webapp;
                postgres    false            �            1259    24944    admins    TABLE        CREATE TABLE public.admins (
    username character varying(25) NOT NULL,
    n_ame character varying(25) NOT NULL,
    surname character varying(25) NOT NULL,
    password character varying(100) NOT NULL,
    salary numeric(10,3) DEFAULT 1000 NOT NULL,
    salt character varying(50)
);
    DROP TABLE public.admins;
       public         heap    postgres    false            �            1259    24948    call_history    TABLE     �   CREATE TABLE public.call_history (
    from_ character varying(25) NOT NULL,
    to_ character varying(25) NOT NULL,
    started date NOT NULL,
    duration integer
);
     DROP TABLE public.call_history;
       public         heap    postgres    false            �            1259    24951    clients    TABLE     �  CREATE TABLE public.clients (
    username character varying(25) NOT NULL,
    n_ame character varying(25) NOT NULL,
    surname character varying(25) NOT NULL,
    afm character varying(25) NOT NULL,
    phone_number character varying(13) NOT NULL,
    debt numeric(5,2) NOT NULL,
    program_id integer NOT NULL,
    password character varying(100) NOT NULL,
    minutes_talk integer NOT NULL,
    salt character varying(50)
);
    DROP TABLE public.clients;
       public         heap    postgres    false            �            1259    24954    programs    TABLE     �   CREATE TABLE public.programs (
    program_id integer NOT NULL,
    cost_per_month numeric(5,2) NOT NULL,
    cost_per_minute numeric(5,2) NOT NULL,
    minutes integer NOT NULL,
    program_name character varying(25)
);
    DROP TABLE public.programs;
       public         heap    postgres    false            �            1259    24957    programs_program_id_seq    SEQUENCE     �   CREATE SEQUENCE public.programs_program_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.programs_program_id_seq;
       public          postgres    false    205            '           0    0    programs_program_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.programs_program_id_seq OWNED BY public.programs.program_id;
          public          postgres    false    206            �            1259    24959    sellers    TABLE       CREATE TABLE public.sellers (
    username character varying(25) NOT NULL,
    n_ame character varying(25) NOT NULL,
    surname character varying(25) NOT NULL,
    salary numeric(10,2) NOT NULL,
    password character varying(100) NOT NULL,
    salt character varying(50)
);
    DROP TABLE public.sellers;
       public         heap    postgres    false            �
           2604    24973    programs program_id    DEFAULT     z   ALTER TABLE ONLY public.programs ALTER COLUMN program_id SET DEFAULT nextval('public.programs_program_id_seq'::regclass);
 B   ALTER TABLE public.programs ALTER COLUMN program_id DROP DEFAULT;
       public          postgres    false    206    205                      0    24944    admins 
   TABLE DATA           R   COPY public.admins (username, n_ame, surname, password, salary, salt) FROM stdin;
    public          postgres    false    202   j                 0    24948    call_history 
   TABLE DATA           E   COPY public.call_history (from_, to_, started, duration) FROM stdin;
    public          postgres    false    203                    0    24951    clients 
   TABLE DATA           ~   COPY public.clients (username, n_ame, surname, afm, phone_number, debt, program_id, password, minutes_talk, salt) FROM stdin;
    public          postgres    false    204   e                 0    24954    programs 
   TABLE DATA           f   COPY public.programs (program_id, cost_per_month, cost_per_minute, minutes, program_name) FROM stdin;
    public          postgres    false    205                     0    24959    sellers 
   TABLE DATA           S   COPY public.sellers (username, n_ame, surname, salary, password, salt) FROM stdin;
    public          postgres    false    207   }       (           0    0    programs_program_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.programs_program_id_seq', 3, true);
          public          postgres    false    206            �
           2606    24964    admins admins_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.admins
    ADD CONSTRAINT admins_pkey PRIMARY KEY (username);
 <   ALTER TABLE ONLY public.admins DROP CONSTRAINT admins_pkey;
       public            postgres    false    202            �
           2606    24966    call_history call_history_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public.call_history
    ADD CONSTRAINT call_history_pkey PRIMARY KEY (from_, to_, started);
 H   ALTER TABLE ONLY public.call_history DROP CONSTRAINT call_history_pkey;
       public            postgres    false    203    203    203            �
           2606    24968    clients clients_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (username);
 >   ALTER TABLE ONLY public.clients DROP CONSTRAINT clients_pkey;
       public            postgres    false    204            �
           2606    24970    programs programs_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.programs
    ADD CONSTRAINT programs_pkey PRIMARY KEY (program_id);
 @   ALTER TABLE ONLY public.programs DROP CONSTRAINT programs_pkey;
       public            postgres    false    205            �
           2606    24979 "   programs programs_program_name_key 
   CONSTRAINT     e   ALTER TABLE ONLY public.programs
    ADD CONSTRAINT programs_program_name_key UNIQUE (program_name);
 L   ALTER TABLE ONLY public.programs DROP CONSTRAINT programs_program_name_key;
       public            postgres    false    205            �
           2606    24972    sellers sellers_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.sellers
    ADD CONSTRAINT sellers_pkey PRIMARY KEY (username);
 >   ALTER TABLE ONLY public.sellers DROP CONSTRAINT sellers_pkey;
       public            postgres    false    207               �   x���;! k8�N��hk����� k��]�,&����MmH��$��|��}zb�7�������N�ƞ�Fon��J!�H眭���5�����]��g�sI)&���i��Dh�W���_�u�{Y��wWF)� �D�         R   x�+.I,��,�/)J��/������I��4202�50�5��4�*FSU�Y��X�Pc�ih��(;(�0�\����Д+F��� �#G         �   x���=�0����RZ���gu4!7x��B�h���qsu;�t��z>T*L�� ��������۔$$"Dbb�(imb�uB�R
%��-�1�B�.ۘĦ���.�J�R����84������'߭���|B�&T<����	@��'�<k���ѩ���(���QWd         Q   x�3�42�30�4�34 28SR�KsJ���Ӌs��9M!
L9�����̒����|.#�P�!�����X ����� l=�          �   x���A� ���p2�T٩�@�n&e�5UH�&��4�����}�R�Ek囐)SL9�c*�Q"B-:�Sֆ��?Z�lZ��2Mwz�,���P�����coT���(V�N�\��u�U�H!�qRC@     