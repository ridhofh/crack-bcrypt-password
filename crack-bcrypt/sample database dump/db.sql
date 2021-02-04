--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `photo`, `email`, `password`, `id_privileges`, `created_at`, `updated_at`, `status`) VALUES
(1, 'Super Admin', 'uploads/1/2021-01/sadmin.jpg', 'superadmin@company.co.id', '$2a$10$FMniiwyewiiQDcPZz26X9eOIchXktWO8kBciEEqmx1qRuOA2m7WRO', 1, '2021-01-01 00:59:23', '2021-01-12 04:11:18', NULL),
(5, 'Admin', 'uploads/1/2021-01/admin.jpg', 'admin@company.co.id', '$2a$10$jx/qQe.pDuX2h0i9QVyzSOQUQ.P.hDdQQoeC1x1pVUNoQw5A/jaUi', 4, '2021-01-06 01:51:30', '2021-01-07 02:25:31', NULL),
(6, 'User_1', 'uploads/1/2021-01/user1.jpg', 'user1@company.co.id', '$2a$10$ApnuWv1YaPVOWMccxk8nUeVbpOXyk6g1HG67KpozOb0AH11nPJqa2', 3, '2021-01-07 02:01:30', NULL, NULL),
(7, 'User_2', 'uploads/1/2021-01/user2.jpg', 'user2@company.co.id', '$2a$10$I/yNzTkgBSHfleHPMa3kw.Cl7LwASHdE/Gxw/pXoTeYHyGMGtKSjW', 3, '2021-01-07 02:03:40', NULL, NULL),
(14, 'User_3', 'uploads/1/2021-01/user3.jpg', 'user3@company.co.id', '$2a$10$YpDyZ3qGVBFuFAe/XQObeu5XIGRLeDa4VmREGlBkIxfledUd4GQUi', 5, '2021-01-08 08:58:52', '2021-01-12 04:11:37', NULL);

-- --------------------------------------------------------