PGDMP         &                 }            postgres    14.1    15.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    13754    postgres    DATABASE     s   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3316                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    4            �           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    4            �            1259    16387    proveedores    TABLE     x  CREATE TABLE public.proveedores (
    proveedor_id integer NOT NULL,
    ruc_proveedor character varying(20) NOT NULL,
    nombre_proveedor character varying(255) NOT NULL,
    correo_proveedor character varying(100),
    telefono_proveedor character varying(15),
    direccion_proveedor text,
    estado_proveedor character varying(45) DEFAULT 'activo'::character varying
);
    DROP TABLE public.proveedores;
       public         heap    postgres    false    4            �            1259    16386    proveedores_proveedor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.proveedores_proveedor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.proveedores_proveedor_id_seq;
       public          postgres    false    210    4            �           0    0    proveedores_proveedor_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.proveedores_proveedor_id_seq OWNED BY public.proveedores.proveedor_id;
          public          postgres    false    209            \           2604    16390    proveedores proveedor_id    DEFAULT     �   ALTER TABLE ONLY public.proveedores ALTER COLUMN proveedor_id SET DEFAULT nextval('public.proveedores_proveedor_id_seq'::regclass);
 G   ALTER TABLE public.proveedores ALTER COLUMN proveedor_id DROP DEFAULT;
       public          postgres    false    210    209    210            �          0    16387    proveedores 
   TABLE DATA           �   COPY public.proveedores (proveedor_id, ruc_proveedor, nombre_proveedor, correo_proveedor, telefono_proveedor, direccion_proveedor, estado_proveedor) FROM stdin;
    public          postgres    false    210          �           0    0    proveedores_proveedor_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.proveedores_proveedor_id_seq', 25, true);
          public          postgres    false    209            _           2606    16395    proveedores proveedores_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.proveedores
    ADD CONSTRAINT proveedores_pkey PRIMARY KEY (proveedor_id);
 F   ALTER TABLE ONLY public.proveedores DROP CONSTRAINT proveedores_pkey;
       public            postgres    false    210            a           2606    16397 )   proveedores proveedores_ruc_proveedor_key 
   CONSTRAINT     m   ALTER TABLE ONLY public.proveedores
    ADD CONSTRAINT proveedores_ruc_proveedor_key UNIQUE (ruc_proveedor);
 S   ALTER TABLE ONLY public.proveedores DROP CONSTRAINT proveedores_ruc_proveedor_key;
       public            postgres    false    210            �   �   x��пj�0�Yy
=A��/��R�pt0t�"r|��������+I��j0X�OYP�3���|-K�RQuܾ�)\9�v*W�6���/�R��0��kd4b��3.�Q
�Ҋ�`w�����K���<�'\7��%��h��b^�i�?��#x���5�f���i����/y�-��}���j7�F�6�/��0�w�HE��`?ڦi� �[yK     